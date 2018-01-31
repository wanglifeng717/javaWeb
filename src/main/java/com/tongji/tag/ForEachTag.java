/**
* Title: ForEachTag.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 30, 2018
* @version 1.0
*/
package com.tongji.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**  
* Title: ForEachTag 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 30, 2018  
*/
public class ForEachTag  extends SimpleTagSupport{

	private Collection<?> items;
	public void setItems(Collection<?> items) {
		this.items= items;
	}
	private String var;
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
//		* 遍历 items 对应的集合
		if(items != null){
			for(Object obj: items){
		//		* 把正在遍历的对象放入到 pageContext 中, 键: var, 值: 正在遍历的对象. 
				getJspContext().setAttribute(var, obj);
			
				//把标签体的内容直接输出到页面上. 
				getJspBody().invoke(null); 
			}
		}
	}
}
