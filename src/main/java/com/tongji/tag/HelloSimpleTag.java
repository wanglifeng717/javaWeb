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

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**  
* Title: HelloSimpleTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 25, 2018  
*/
public class HelloSimpleTag implements SimpleTag {

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
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

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext");

	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
