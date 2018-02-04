package com.tongji.content;

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
 * Servlet Filter implementation class ContentFilter
 */
public class ContentFilter extends HttpFilter  {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//1. 获取请求 content 参数的值
    	String content = request.getParameter("content");
    	
    	System.out.println(request); 
    	HttpServletRequest req = new MyHttpServletRequest(request);
    	
    	//2. 把其中 fuck, shit 等字符串替换换为 ****
    	if(content.contains(" fuck ")){
    		//SerletRequest, HttpServletRequest 中并没有提供诸如 setParameter(paramName, paramValue)
    		//类似于这样的方法. 
    		
    		//目标: 改变 HttpServletRequest 的 getParameter(String) 方法的行为: 若该方法的返回值中
    		//包含 " fuck ", 则替换为 " **** "
    		
    		//1. 若对于一个类的方法不满意, 需要进行重写, 最常见的方式是, 继承父类, 重写方法. 
    		//若实现则需要继承 org.apache.catalina.connector.RequestFacade, 而这仅是 Tomcat
    		//服务器的实现, 若更换服务器, 该方案将无法使用. ×. 
    		
    		//2. 直接写一个 HttpServletRequest 接口的实现类: 无法实现	其中方法. ×
    		
    		//3. 装饰目前的 HttpServletRequest 对象: 装饰其 getParameter 方法, 而其他方法还和其实现相同.
    		//创建一个类, 该类实现 HttpServletRequest 接口, 把当前 doFilter 中的 request 传入到该类中, 作为
    		//其成员变量, 使用该成员变量去实现接口的全部方法. 
    		
    	}
    	
    	//3. 转到目标页面
    	filterChain.doFilter(req, response);
	}

    

}
