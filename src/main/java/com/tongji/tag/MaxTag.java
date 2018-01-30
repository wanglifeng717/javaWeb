/**
* Title: MaxTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 29, 2018
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

/**  
* Title: MaxTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 29, 2018  
*/
public class MaxTag implements SimpleTag {

	private String num1;
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	@Override
	public void doTag() throws JspException, IOException {
		int a=0;
		int b=0;
		
		JspWriter out = PageContext.getOut();
		
		try {
			a = Integer.parseInt(num1);
			b= Integer.parseInt(num2);
			out.print(a>b?a:b);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {

	}

	private PageContext PageContext;
	@Override
	public void setJspContext(JspContext arg0) {
		this.PageContext = (javax.servlet.jsp.PageContext) arg0;
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

	}

}
