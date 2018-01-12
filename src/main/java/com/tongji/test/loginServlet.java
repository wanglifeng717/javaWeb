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
import java.io.ObjectOutputStream.PutField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
* Title: loginServlet 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 11, 2018  
*/
public class loginServlet extends myHttpServlet {

	/**功能：
	 * @throws IOException 
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.tongji.test.myHttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String method = request.getMethod();
		System.out.println(method);
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		
		if(initUser.equals(user) && initPassword.equals(password)) {
			out.println("hello \n"+user+" you are premitted");
		} else {
			out.println("sorry \n"+user+" your password or username is wrong");
		}
	}
}
