/**
* Title: TestJspFragment.java
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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: TestJspFragment 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 30, 2018  
*/
public class TestJspFragment extends SimpleTagSupport {

	
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment bodyContent = getJspBody();
		//JspFragment.invoke(Witer): Writer 即为标签体内容输出的字符流, 若为 null, 则
		//输出到 getJspContext().getOut(), 即输出到页面上.
		//bodyContent.invoke(null);
		
		//1. 利用 StringWriter 得到标签体的内容.
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
				
		//2. 把标签体的内容都变为大写
		String content = sw.toString().toUpperCase();
				
		//3. 获取 JSP 页面的 out 隐含对象, 输出到页面上
		getJspContext().getOut().print(content);
		
	}
}
