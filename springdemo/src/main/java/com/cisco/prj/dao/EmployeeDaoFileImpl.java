package com.cisco.prj.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Employee;


//@Profile("dev")
//@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) {
		System.out.println("file store!!!");
	}

}
