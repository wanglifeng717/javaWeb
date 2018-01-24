package com.tongji.javaWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessStep2Servlet
 */
public class ProcessStep2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 获取请求参数: name, address, cardType, card
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String cardType = request.getParameter("cardType");
				String card = request.getParameter("card");
				//有很多属性，我们自然想到了封装，用类封装是比较普遍的做法。
				Customer customer = new Customer(name, address, cardType, card);
				
				//2. 把请求信息存入到 HttpSession 中
				
				HttpSession session = request.getSession();
				//在jsp中可以直接用，但是在这里不能，因为不是隐含对象
				session.setAttribute("customer", customer);
				
				//3. 重定向页面到 confirm.jsp
				response.sendRedirect(request.getContextPath() + "/shoppingcart/confirm.jsp");
	}

}
