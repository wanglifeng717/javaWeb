/**
* Title: InvalidExtNameException.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 5, 2018
* @version 1.0
*/
package com.tongji.fileupload.app.exception;

/**  
* Title: InvalidExtNameException 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 5, 2018  
*/
public class InvalidExtNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidExtNameException(String msg) {
		super(msg);
	}

}
