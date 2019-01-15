package com.example.demo.dao;


import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeDao {
	void insert(Employee employee);
	List<Employee> allEmpolyees();
}
