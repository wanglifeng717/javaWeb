/**
* Title: MyHttpServletRequest.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 4, 2018
* @version 1.0
*/
package com.tongji.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**  
* Title: MyHttpServletRequest 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 4, 2018  
*/
public class MyHttpServletRequest extends HttpServletRequestWrapper {

	/**
	 * @param request
	 */
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		String val = super.getParameter(name);
		if(val!=null && val.contains("fuck")) {
			val = val.replace("fuck", "****");
		}
		return val;
	}

}
