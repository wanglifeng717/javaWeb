/**
* Title: JdbcUtilsTest.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.tongji.db.JdbcUtils;

/**  
* Title: JdbcUtilsTest 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class JdbcUtilsTest {

	//测试数据库连接是否已经获得。
	@Test
	public void testGetConnection() throws SQLException {
		Connection connection= JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
