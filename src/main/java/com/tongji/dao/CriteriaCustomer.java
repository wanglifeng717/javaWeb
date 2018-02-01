/**
* Title: CriteriaCustomer.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.dao;

/**  
* Title: CriteriaCustomer 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class CriteriaCustomer {
	private String name;
	private String address;
	private String phone;
	
	
	public CriteriaCustomer(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		//这里这样写，主要是为了模糊参询的时候
		if(name ==null)
			name ="%%";
		else 
			name="%"+name+"%";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		if(address ==null)
			address ="%%";
		else 
			address="%"+address+"%";
		
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		if(phone ==null)
			phone ="%%";
		else 
			phone="%"+phone+"%";
		
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
