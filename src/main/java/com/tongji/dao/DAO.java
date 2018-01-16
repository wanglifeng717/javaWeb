/**
* Title: DAO.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tongji.db.JdbcUtils;

/**  
** 这个DAO是和业务无关的。可以被重用的。
 * 封装了基本的 CRUD 的方法, 以供子类继承使用
 * 当前 DAO 直接在方法中获取数据库连接. 
 * 整个 DAO 采取 DBUtils 解决方案. 
 * @param <T>: 当前 DAO 处理的实体类的类型是什么
 */ 

public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public DAO() {
		
		//clazz = ReflectionUtils.getSuperGenericType(getClass());
		
		/*
		System.out.println("DAO's construtor...");
		System.out.println(this.toString()); //CustomerDAOJdbcImpl
		
		Class clazz2 = this.getClass(); //CustomerDAOJdbcImpl.class
		System.out.println(clazz2); 		
		
		//com.atguigu.mvcapp.dao.DAO 没有希望的泛型参数
		Class clazz3 = this.getClass().getSuperclass();
		System.out.println(clazz3); 
		
		//DAO<Customer>
		Type type = this.getClass().getGenericSuperclass();
		System.out.println(type); 
		
		//true
		System.out.println(type instanceof ParameterizedType); 
		
		//[class com.atguigu.mvcapp.domain.Customer]
		ParameterizedType type2 = (ParameterizedType) type;
		Type [] typeArgs = type2.getActualTypeArguments();
		System.out.println(Arrays.asList(typeArgs)); 
		
		//class com.atguigu.mvcapp.domain.Customer
		Type typeArg = typeArgs[0];
		System.out.println(typeArg);
		
		System.out.println(typeArg instanceof Class);
		
		if(typeArg instanceof Class){
			clazz = (Class<T>) typeArg;
		}
		*/
		 Type superclass = getClass().getGenericSuperclass();
		 if(superclass instanceof ParameterizedType) {
			 ParameterizedType parameterizedType=(ParameterizedType) superclass;
			 
			 Type[] args = parameterizedType.getActualTypeArguments();
			 if(args!=null && args.length>0) {
				 if(args[0] instanceof Class) {
					 clazz = (Class<T>)args[0];
					 //System.out.println(clazz);
				 }
			 }
		 }
	}
	
	/**
	 * 返回某一个字段的值：例如返回某一条记录的 customerName, 或返回数据表中有多少条记录等. 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object ... args){
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 返回 T 所对应的 List 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * 返回对应的 T 的一个实例类的对象. 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * 该方法封装了 INSERT、DELETE、UPDATE 操作.
	 * @param sql: SQL 语句
	 * @param args: 填充 SQL 语句的占位符.
	 */
	public void update(String sql, Object ... args){
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
	}
}
