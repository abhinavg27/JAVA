package com.cisco.prj.dao;

import com.cisco.prj.entity.Order;

public interface OrderDao {
	void addOrder(Order o);
	Order getOrder(int id);
}
