/**
* Title: CustomerDAOFactory.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.dao.factory;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.tongji.dao.CustomerDAO;
import com.tongji.dao.impl.CustomerDAOJdbcImpl;
import com.tongji.dao.impl.CustomerDAOXMLImpl;

/**  
* Title: CustomerDAOFactory 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class CustomerDAOFactory {

	private Map<String , CustomerDAO> daos = new HashMap<>();
	//工厂模式一般都是单例模式。
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXMLImpl());
	}
	public static CustomerDAOFactory getInstance() {
		return instance;
	}
	
	private String type =null;
	public void setType(String type) {
		this.type= type;
	}
	
	public CustomerDAO getCustomerDAO() {
		return daos.get(type);
	}
}
