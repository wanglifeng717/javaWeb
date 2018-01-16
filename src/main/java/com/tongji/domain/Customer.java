/**
* Title: Customer.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.domain;

/**  
* Title: Customer 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class Customer {
   private int id;
   private String name;
   private String address;
   private String phone;
   
   
	public Customer(String name, String address, String phone) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	public Customer(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
