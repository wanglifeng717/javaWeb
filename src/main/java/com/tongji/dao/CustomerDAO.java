/**
* Title: CustomerDAO.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 16, 2018
* @version 1.0
*/
package com.tongji.dao;

import java.util.List;

import com.tongji.domain.Customer;

/**  
* Title: CustomerDAO 
* Description:  
* @author mdm(computer in lab)  
* @date Jan 16, 2018  
*/
public interface CustomerDAO {

	//模糊参询的函数，新建查询条件的类CriteriaCustomer，因为我们很多时候的查询条件customer里面不能全部的包含。
	//所以查询条件单独的封装成一个类。
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	public List<Customer> getAll();
	
	//添加一条记录
	public void save(Customer customer);
	
	//按照id查一个员工
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Customer customer);
	
	/** 
	 * 返回和 name 相等的记录数. 
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
