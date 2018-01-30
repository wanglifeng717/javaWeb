/**
* Title: PrintUpperTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 30, 2018
* @version 1.0
*/
package com.tongji.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: PrintUpperTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 30, 2018  
*/
public class PrintUpperTag extends SimpleTagSupport {

	//参数一般都是传String类型，不容易传错。
	private String time;
	
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jspBody = getJspBody();
		
		StringWriter sWriter = new StringWriter();
		jspBody.invoke(sWriter);
		
		String content = sWriter.toString().toUpperCase();
		
		int count = 1;
		try {
			count = Integer.parseInt(time);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i < count;i++) {
			getJspContext().getOut().print(content+"<br>");
		}
	}
}

