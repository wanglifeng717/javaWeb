package com.tongji.authority;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//我们在MVC的时候见过，我们多个请求都发到发到一个Servlet里面，需要用反射去执行不同方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		
		try {
			//利用反射找到要执行的方法，然后直接调用
			Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private UserDao userDao = new UserDao();
	
	public void getAuthorities(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userDao.get(username);
		
		request.setAttribute("user", user);
		request.setAttribute("authorities", userDao.getAuthorities());
		
		request.getRequestDispatcher("/authority/authority-manager.jsp").forward(request, response);
		
	}
	public void updateAuthorities(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String [] authorities = request.getParameterValues("authority");
		//新权限和全部的权限进行比较，中的放到数组里面，然后统一更新，用户的权限
		List<Authority> authorityList = userDao.getAuthorities(authorities);
		
		userDao.update(username, authorityList);
		response.sendRedirect(request.getContextPath() + "/authority/authority-manager.jsp");
		
	}

}
