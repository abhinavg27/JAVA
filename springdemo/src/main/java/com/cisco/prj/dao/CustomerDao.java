package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Customer;

public interface CustomerDao {
	void addCustomer(Customer c);
	List<Customer> getCustomers();
}


