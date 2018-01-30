/**
* Title: ReadFileTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 29, 2018
* @version 1.0
*/
package com.tongji.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: ReadFileTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 29, 2018  
*/
public class ReadFileTag  extends SimpleTagSupport{

	//相对于当前 WEB 应用的根路径的文件名
	private String  src;
	public void setSrc(String src) {
		this.src= src;
	}
	public void doTag() throws IOException {
		PageContext pageContext = (PageContext) getJspContext();
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String str =null;
		while((str=reader.readLine())!=null) {
			//我们文件中的<会被浏览器解析为标签的前奏会自动转为HTML的形式，必须转换
			str = Pattern.compile("<").matcher(str).replaceAll("&lt");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt");
			
			pageContext.getOut().print(str);
			pageContext.getOut().print("<br>");
		}
	}
}
