package com.tongji.authority;

import com.tongji.filter.HttpFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;


public class AuthorityFilter extends HttpFilter  {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//获取servletPath 类似于 /app_3/article1.jsp
		String servletPath = request.getServletPath();
		//System.out.println(servletPath);
		//不需要拦截的url列表
		List<String> uncheckedUrls = Arrays.asList("/authority/403.jsp", "/authority/articles.jsp", 
				"/authority/authority-manager.jsp", "/authority/login.jsp", "/authority/logout.jsp");
		
		if(uncheckedUrls.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return ;
		}
		//在用户已经登录(可使用 用户是否登录 的过滤器)的情况下, 获取用户信息. session.getAttribute("user")
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/authority/login.jsp");
			return ;
		}
//		- 再获取用户所具有的权限的信息: List<Authority>
		List<Authority> authorities = user.getAuthorities();
		//检验用户是否有请求servletPath的权限
		Authority authority = new Authority(null,servletPath);
		//若有权限，则相应,这里contains必须要重写Authority的equals和hashcode方法。
		if(authorities.contains(authority)) {
			filterChain.doFilter(request, response);
			return ;
		}
		
		//若没有权限，重定向到403.jsp
		response.sendRedirect(request.getContextPath()+"/authority/403.jsp");
	}

	

}
