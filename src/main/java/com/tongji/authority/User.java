/**
* Title: User.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 2, 2018
* @version 1.0
*/
package com.tongji.authority;

import java.util.List;

/**  
* Title: User 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 2, 2018  
*/
public class User {

	private String userName;
	private List<Authority> authorities;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public User(String userName, List<Authority> authorities) {
		super();
		this.userName = userName;
		this.authorities = authorities;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
