/**
* Title: TestparentTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 31, 2018
* @version 1.0
*/
package com.tongji.parentTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: TestparentTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 31, 2018  
*/
public class ParentTag  extends SimpleTagSupport{
	private String name ="www.ATGUIGU.com";
	
	public String getName() {
		return name;
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签的标签处理类name："+name);
		getJspBody().invoke(null);
	}
	
}
