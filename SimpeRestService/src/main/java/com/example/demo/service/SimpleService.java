package com.example.demo.service;

import com.example.demo.dao.CompanyDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleService {
	
	@Autowired 
	EmployeeDao employeeDao;
	
	@Autowired 
	CompanyDao companyDao;
	
	@GetMapping(value = "/rest/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
		Employee employee = new Employee();
		employee.setId(id);
		return employee;
    }
	
	@GetMapping(value = "/rest/employees")
    public List<Employee> getAllEmployees() {
		return employeeDao.allEmpolyees();
    }
	
	@PostMapping(value = "/rest/employee")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
		System.out.println(newEmployee.getSalary());
		employeeDao.insert(newEmployee);
		return newEmployee;
    }
	
    @GetMapping(value = "/rest/companies")
    public List<String> getAllCompanyNames() {
		return companyDao.getCompanyNames();
    }
    
    @GetMapping(value = "/rest/company/{name}")
    public BigDecimal getCompanyCost(@PathVariable String name) {
		return companyDao.getCompanyCost(name);
    }
}
