package com.tongji.parentTag;
/**
* Title: Otherwise.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 31, 2018
* @version 1.0
*/

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: Otherwise 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 31, 2018  
*/
public class Otherwise extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		Choose choose = (Choose) getParent();
		if(choose.isFlag()) {
			getJspBody().invoke(null);
		}
	}
}
