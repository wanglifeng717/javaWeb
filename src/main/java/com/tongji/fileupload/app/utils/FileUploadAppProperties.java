/**
* Title: FileUploadAppProperties.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 5, 2018
* @version 1.0
*/
package com.tongji.fileupload.app.utils;

import java.util.HashMap;
import java.util.Map;

/**  
* Title: FileUploadAppProperties 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 5, 2018  
*/
public class FileUploadAppProperties {

	private Map<String, String> properties = new HashMap<>();
	private FileUploadAppProperties() {
		
	}
	private static FileUploadAppProperties instance = new FileUploadAppProperties();
	
	public static FileUploadAppProperties getInstance() {
		return instance;
	}
	public void addProperty(String propertyName,String propertyValue) {
		properties.put(propertyName, propertyValue);
	}
	public String getProperty(String propertyName) {
		return properties.get(propertyName);
	}
}
