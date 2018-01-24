package com.tongji.javaWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.ParentRunner;


public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//为了回显已经填写的数据。吧数据保留在session中
		HttpSession session = request.getSession();
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("password", request.getParameter("password"));
		
		
		
		//1.获取请求参数：CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME").toLowerCase();
		//2.获取session中的CHECK_CODE_PARAM_NAME
		String sessionCode = ((String)request.getSession().getAttribute("CHECK_CODE_KEY")).toLowerCase();
		//3.比对，看是否一致，若一致说明验证码正确，不一致说明验证码错误，把信息放入到session中，从定向到开始界面，读取信息
		System.out.println(paramCode+":"+sessionCode);
		//如果验证码没填，我们认为是点击刷新验证码去了。所以不返回“验证码不对”的提示信息。
		if(paramCode=="") {
			response.sendRedirect(request.getContextPath()+"/check/check.jsp");
			return;
		}
		if( !(paramCode!=null && paramCode.equals(sessionCode))) {
			request.getSession().setAttribute("message", "验证码不对");
			response.sendRedirect(request.getContextPath()+"/check/check.jsp");
			return;
		}
		//验证通过的话，我们就可以重定向到登录成功的界面上去
		//但是现在只是打印成功即可
		System.out.println("受理成功");
		

	}
}
