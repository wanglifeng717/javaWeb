/**
* Title: myGenericServlet.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 11, 2018
* @version 1.0
*/
package com.tongji.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**  
* Title: myGenericServlet 
* Description:  自己定义的myGenericServlet方法。
* @author mdm(computer in lab)  
* @date Jan 11, 2018  
*/
public abstract class myGenericServlet implements Servlet,ServletConfig {

	/** 以下方法为 Servlet 接口的方法 **/
	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		init();
	}

	public void init() throws ServletException{}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;

	/** 以下方法为 ServletConfig 接口的方法 **/
	@Override
	public String getInitParameter(String arg0) {
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

}
