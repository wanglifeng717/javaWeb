package com.tongji.test;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forwardServlet 's doGet");
		//因为发的是一次请求，所以我们最后设置的参数，在testServlet里面还是能获取到的。
		request.setAttribute("forward_name", "forwardservlet.name");
		System.out.println("ForwardServlet's name: "+request.getAttribute("forward_name"));
		//请求的转发.
		//1. 调用 HttpServletRequest 的 getRequestDispatcher() 方法获取  RequestDispatcher 对象
		//调用 getRequestDispatcher() 需要传入要转发的地址
		String path="testServlet";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/"+path);
		//2. 调用 HttpServletRequest 的 forward(request, response) 进行请求的转发. 
		requestDispatcher.forward(request, response); 
	}

}








