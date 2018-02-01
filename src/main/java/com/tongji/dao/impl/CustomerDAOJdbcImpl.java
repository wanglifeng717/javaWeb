/**
* Title: CustomerDAOJdbcImpl.java
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
import com.tongji.dao.DAO;
import com.tongji.domain.Customer;

/**  
* Title: CustomerDAOJdbcImpl 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	
	
	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id, name, address, phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name, address, phone) VALUES(?,?,?)";
		update(sql, customer.getName(), customer.getAddress(), customer.getPhone()); 
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		return get(sql, id); 
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM customers WHERE name = ?";
		return getForValue(sql, name); 
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customers SET name = ?, address = ?, phone = ? " +
				"WHERE id = ?";
		update(sql, customer.getName(), customer.getAddress(), 
				customer.getPhone(), customer.getId());
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql ="select id,name,address,phone from customers where name like ? and address like ? and phone like ?";
		
		return getForList(sql, cc.getName(),cc.getAddress(),cc.getPhone());
	}

}
