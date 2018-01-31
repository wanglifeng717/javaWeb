/**
* Title: Choose.java
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
* Title: Choose 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 31, 2018  
*/
public class Choose extends SimpleTagSupport {

	private boolean flag = true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isFlag() {
		return flag;
	}
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
}
