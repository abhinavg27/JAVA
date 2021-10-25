package com.cisco.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.EmployeeDao;
import com.cisco.prj.entity.Employee;

@Service
public class AppService {
	@Autowired
	private EmployeeDao empDao;
	
	public void storeEmp(Employee e) {
		empDao.addEmployee(e);
	}
}


