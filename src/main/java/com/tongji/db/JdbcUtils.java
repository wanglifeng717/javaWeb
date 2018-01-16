/**
* Title: jdbcUtils.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
* Title: jdbcUtils 
* Description:  获取和释放数据库连接的类。
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class JdbcUtils {

	/**
	 * 释放 Connection 连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static{
		//数据源只能被创建一次. 
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * 返回数据源的一个 Connection 对象
	 * @return
	 * @throws SQLException  
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
