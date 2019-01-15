package com.example.demo.dao;

import com.example.demo.model.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImp extends JdbcDaoSupport implements EmployeeDao {

	 @Autowired 
	 DataSource dataSource;
	 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
	    
	@Override
	public void insert(Employee employee) {
		  String sql = "INSERT INTO bookstore.employee " + "(first_name, last_name, address,salary, company) VALUES (?, ?, ?, ?, ?)" ;
		  getJdbcTemplate().update(sql, new Object[]{employee.getFirstName(), 
				  									employee.getLastName(), 
				  									employee.getAddress(),
				  									employee.getSalary(),
				  									employee.getCompany()});
   }
	
	@Override
	public List<Employee> allEmpolyees() {
		  String sql = "SELECT * FROM bookstore.employee";
		  List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		  List<Employee> list = new ArrayList<>();
		  for(Map<String, Object> row:rows){
			    Employee e = new Employee();
				e.setFirstName((String)row.get("first_name"));
				e.setLastName((String)row.get("last_name"));
				e.setAddress((String)row.get("address"));
				e.setCompany((String)row.get("company"));
				e.setSalary((BigDecimal)row.get("salary"));
				list.add(e);
			}
		 return list;
   }

}
