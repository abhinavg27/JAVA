package com.cisco.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.prj.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
