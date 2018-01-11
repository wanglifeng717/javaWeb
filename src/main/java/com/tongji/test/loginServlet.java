/**
* Title: loginServlet.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 11, 2018
* @version 1.0
*/
package com.tongji.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**  
* Title: loginServlet 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 11, 2018  
*/
public class loginServlet implements Servlet{

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("有请求来了。。。。");
		/*①. 获取请求参数: 

			> String getParameter(String name): 根据请求参数的名字, 返回参数值. 
			若请求参数有多个值(例如 checkbox), 该方法只能获取到第一个提交的值，所以用下面这个方法. 

			> String[] getParameterValues(String name): 根据请求参数的名字, 返回请求参数对应的字符串数组. 
			
			> Enumeration getParameterNames(): 返回参数名对应的 Enumeration 对象, 
			类似于 ServletConfig(或 ServletContext) 的 getInitParameterNames() 方法. 
			这个方法同样的问题就是，获取例如checkbox多值类型的还是只返回第一个。
			
			> Map getParameterMap(): 返回请求参数的键值对: key: 参数名,  value: 参数值, String 数组类型. 
*/
		//输入tongji  123
		String name= req.getParameter("user");
		System.out.println(name);//tongji
		
		String[] interesting = req.getParameterValues("interesting");
		System.out.println(Arrays.toString(interesting));//[game, party]
		
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements())
		{
			String name1 = names.nextElement();
			String value = req.getParameter(name1);
			System.out.println("Enumeration: "+name1+":"+value);
		}
		/*
			Enumeration: user:tongji
			Enumeration: password:123
			Enumeration: interesting:game
		*/
		
		Map<String, String[]> map = req.getParameterMap();
		for(Map.Entry<String, String[]> entry:map.entrySet()) {
			System.out.println("map: "+ entry.getKey()+Arrays.toString(entry.getValue()));
		}
				/*map: user[tongji]
				map: password[123]
				map: interesting[game, party]*/
		
		
		/* 获取请求的 URI:*/		
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		String requestURI=httpServletRequest.getRequestURI();
		System.out.println(requestURI);///javaWeb/login
		
		/*获取请求方式:  

			String method = httpServletRequest.getMethod();
			System.out.println(method); //GET
			
		④. 若是一个 GET 请求, 获取请求参数对应的那个字符串, 即 ? 后的那个字符串. 

			String queryString = httpServletRequest.getQueryString();//如果是post 返回就是Null
			System.out.println(queryString);
			 //user=atguigu&password=1234&interesting=game&interesting=party&interesting=shopping
*/
		String method = httpServletRequest.getMethod();
		System.out.println(method);//GET
		
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);//user=tongji&password=123&interesting=game&interesting=party
		//获取请求的 Serlvet 的映射路径 
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);// /login
		
		String remoteAddr = httpServletRequest.getRemoteAddr();
		System.out.println(remoteAddr); //127.0.0.1
		StringBuffer requestURL = httpServletRequest.getRequestURL();
		System.out.println(requestURL);//http://127.0.0.1:8080/javaWeb/login
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
