/**
* Title: myHttpServlet.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 12, 2018
* @version 1.0
*/
package com.tongji.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
* Title: myHttpServlet 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 12, 2018  
*/
public class myHttpServlet extends myGenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request=(HttpServletRequest) arg0;
			response=(HttpServletResponse) arg1;
			
		}catch (Exception e) {
			throw new ServletException("non-Http request or response");
		}
		service(request, response);
		
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String method = request.getMethod();
		
		if("get".equalsIgnoreCase(method)) {
			doGet(request,response);
		}else if("post".equalsIgnoreCase(method)) {
			doPost(request,response);
		}
	}
	/**功能：
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}
	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
