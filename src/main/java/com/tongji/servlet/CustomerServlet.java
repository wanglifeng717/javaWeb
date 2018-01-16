package com.tongji.servlet;

import java.io.IOException;import java.lang.reflect.Modifier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method =request.getParameter("method");
		
		switch (method) {
		case "add":
			add(request,response);
			break;
		case "query":
			query(request,response);
			break;
		case "delete":
			delete(request,response);
			break;

		}
	
	}

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("delete");
		
	}

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("query");
		
	}

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("add");
		
	}

}
