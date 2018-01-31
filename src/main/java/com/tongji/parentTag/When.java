/**
* Title: When.java
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
* Title: When 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 31, 2018  
*/
public class When extends SimpleTagSupport {

	private boolean test;
	public void setTest(boolean test) {
		this.test= test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		
		if(test) {
			Choose choose = (Choose) getParent();
			boolean flag= choose.isFlag();
			if(flag) {
				getJspBody().invoke(null);
				choose.setFlag(false);
			}
		}
	}
}
