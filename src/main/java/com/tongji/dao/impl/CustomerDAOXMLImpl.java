/**
* Title: CustomerDAOXMLImpl.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.dao.impl;

import java.util.List;

import com.tongji.dao.CriteriaCustomer;
import com.tongji.dao.CustomerDAO;
import com.tongji.domain.Customer;

/**  
* Title: CustomerDAOXMLImpl 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("save");
	}

	@Override
	public Customer get(Integer id) {
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");
	}

	@Override
	public void update(Customer customer) {
		System.out.println("update");
	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("getCountWithName");  
		return 0;
	}
}
