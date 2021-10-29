package com.cisco.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
}
