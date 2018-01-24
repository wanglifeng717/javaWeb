package com.tongji.javaWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//为了让线程停一会，我可以在多点几次提交按钮进行测试。
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//处理表单重复提交
		HttpSession session  = request.getSession();
		
		Object token = session.getAttribute("token");
		String tokenValue = request.getParameter("token");
		
		System.out.println(token+":"+tokenValue);
		if(token != null && token.equals(tokenValue)) {
			session.removeAttribute("token");
		}else {
			response.sendRedirect(request.getContextPath()+"/token/token.jsp");
			return;
		}
		
		
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		//这种情况，我们点击刷新，会出现重复提交的情况，因为转发的方式url还是停留在servlet的页面上
		//request.getRequestDispatcher("/token/success.jsp").forward(request, response);
		//这个时候是转发，url已经完全是success的目标位置了，怎么刷新都是无所谓的。
		response.sendRedirect("/javaWeb/token/success.jsp");
	}

}
