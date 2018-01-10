/**
* Title: HelloWorldServlet.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 10, 2018
* @version 1.0
*/
package com.tongji.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**  
* Title: HelloWorldServlet 
* Description:  第一个servlet程序。
* @author mdm(computer in lab)  
* @date Jan 10, 2018  
*/
public class HelloWorldServlet implements Servlet{

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}
	public HelloWorldServlet() {
		System.out.println("HelloWorldServlet's construction");
	}

}
