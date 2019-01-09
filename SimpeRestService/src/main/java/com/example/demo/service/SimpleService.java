package com.example.demo.service;

import com.example.demo.model.Employee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleService {
	
	@GetMapping(value = "/rest/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
		Employee employee = new Employee();
		employee.setId(id);
		return employee;
    }
	
	@PostMapping(value = "/rest/employee")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
		return newEmployee;
    }
}
