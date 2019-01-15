package com.example.demo.dao;

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
public class CompanyDaoImp extends JdbcDaoSupport implements CompanyDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<String> getCompanyNames() {
		String sql = "SELECT distinct company FROM bookstore.employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<String> list = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			list.add((String) row.get("company"));
		}
		return list;

	}

	@Override
	public BigDecimal getCompanyCost(String companyName) {
		String sql = "SELECT SUM(salary) FROM bookstore.employee where company = ? ";
		BigDecimal cost = (BigDecimal) getJdbcTemplate().queryForObject(sql, new Object[] { companyName },
				BigDecimal.class);
		return cost;
	}

}
