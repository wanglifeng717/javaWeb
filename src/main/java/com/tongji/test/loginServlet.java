/**
* Title: loginServlet.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 11, 2018
* @version 1.0
*/
package com.tongji.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.lang.model.type.NullType;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**  
* Title: loginServlet 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 11, 2018  
*/
public class loginServlet extends HttpServlet {

	/**功能：
	 * @throws IOException 
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.tongji.test.myHttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paraUser = request.getParameter("user");
		String paraPassword = request.getParameter("password");

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql:///mydata";
			String user="root";
			String password="root";
			
			connection=DriverManager.getConnection(url,user,password);
			String sql="select count(id) from customer where name=? and email= ?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, paraUser);
			preparedStatement.setString(2, paraPassword);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
				if(count>0) {
					out.println("you are right");
				}else {
					out.print("you are wrong");
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
