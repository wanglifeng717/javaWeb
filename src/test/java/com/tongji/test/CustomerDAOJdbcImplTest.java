/**
* Title: CustomerDAOJdbcImplTest.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tongji.dao.CustomerDAO;
import com.tongji.dao.impl.CustomerDAOJdbcImpl;
import com.tongji.domain.Customer;

/**  
* Title: CustomerDAOJdbcImplTest 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class CustomerDAOJdbcImplTest {

	private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();
	
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	//测试存进去一个新的记录。
	@Test
	public void testSave() {
		Customer customer=new Customer("jerry", "UK", "23989022");
		customerDAO.save(customer);
	}

	
	@Test
	public void testGetInteger() {
		 Customer customer=customerDAO.get(1);
		 System.out.println(customer);
	}

	
	@Test
	public void testDelete() {
		customerDAO.delete(1);
	}

	
	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("tom");
		System.out.println(count);
	}

}
