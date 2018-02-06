package com.atguigu.fileupload.app.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("javawebapp");
	}
	
	public static Connection getConnection(){  
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("");
		}
	}
 
	public static void release(Connection connection) {
		try {
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("");
		}
	}
	
}
