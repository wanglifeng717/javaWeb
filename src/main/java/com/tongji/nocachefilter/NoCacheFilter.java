package com.tongji.nocachefilter;

import com.tongji.filter.HttpFilter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class NoCacheFilter
 */
public class NoCacheFilter extends HttpFilter  {

	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//检查是否工作
		System.out.println("cacheFilter's doFilter..");
		//这三种方式都是可以禁止缓存的，随便选一个就行
		/*response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");*/
		//这个一定记得写
		filterChain.doFilter(request, response);
	}

  

}
