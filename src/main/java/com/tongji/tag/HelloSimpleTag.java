/**
* Title: HelloSimpleTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 25, 2018
* @version 1.0
*/
package com.tongji.tag;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import com.mysql.fabric.xmlrpc.base.Value;

/**  
* Title: HelloSimpleTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 25, 2018  
*/
public class HelloSimpleTag implements SimpleTag {

	//设置两个参数，并生成get和set方法，并到tld文件中去描述两个参数。
	private String value;
	private String count;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = PageContext.getOut();
		int c = Integer.parseInt(count);
		for( int i=0;i<c;i++) {
			out.print((i+1)+":"+value);
			out.print("<br>");
			
		}
	}

	@Override
	public JspTag getParent() {
		System.out.println("JspTag");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	//JSP 引擎调用, 把代表 JSP 页面的 PageContext 对象传入
	//PageContext 可以获取 JSP 页面的其他 8 个隐含对象. 
	//所以凡是 JSP 页面可以做的标签处理器都可以完成.
	private PageContext PageContext;
	@Override
	public void setJspContext(JspContext arg0) {
		//测试jspContext是不是PageContext的子类
		System.out.println(arg0 instanceof PageContext);
		
		this.PageContext = (PageContext) arg0;
		
		//让请求参数支持中文
		try {
			PageContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
