package com.cisco.prj.dao;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Employee;

//	@Profile("prod")
	@Repository
	public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) {
		System.out.println("stored in database!!!");
	}

}
