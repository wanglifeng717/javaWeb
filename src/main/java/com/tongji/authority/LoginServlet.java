package com.tongji.authority;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private UserDao userDao = new UserDao();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取name
		String name = request.getParameter("name");
		
		//2.调用userDao获取用户信息，吧用户信息放入到HTTPSession中
		User user = userDao.get(name);
		System.out.println(user);
		request.getSession().setAttribute("user", user);
		//3.重定向到articles.jsp
		response.sendRedirect(request.getContextPath()+"/authority/articles.jsp");
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取HTTPSession
		
		//2使Session失效
		request.getSession().invalidate();
		//3重定向到/login.jsp
		response.sendRedirect(request.getContextPath()+"/authority/login.jsp");
	}

}
