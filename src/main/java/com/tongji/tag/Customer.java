/**
* Title: Customer.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 30, 2018
* @version 1.0
*/
package com.tongji.tag;

/**  
* Title: Customer 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 30, 2018  
*/
public class Customer {

	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + "]";
	}
	
}
