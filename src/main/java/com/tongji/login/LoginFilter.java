package com.tongji.login;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongji.filter.HttpFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter {

	//1.从web.xml文件中获取 sessionLKey，redirectUrl,uncheckedUrls
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;
	
	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		//放在这里面，只用操作一次，不用每次请求都去获取，效率很高很多
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("rediretPage");
		///login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
		
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//1.获取请求的servletPath
		// /login/b.jsp
		String  servletPath = request.getServletPath();
		
		//2.检查获取的servletPath是否为不需要检查的url中，若是，直接放行，结束方法
		List<String> urList  = Arrays.asList(uncheckedUrls.split(","));
		if(urList.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return ;
		}
		//3.从session中获取sessionKey对应的值，若不存在，则重定向到redirectUrl
		Object attribute = request.getSession().getAttribute(sessionKey);
		if(attribute == null) {
			response.sendRedirect(request.getContextPath()+redirectUrl);
			return;
		}
		//4.若存在，则放行，允许访问
		filterChain.doFilter(request, response);
		
		
	}

   
}
