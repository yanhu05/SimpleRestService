package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

public interface CompanyDao {
  List<String> getCompanyNames();
  BigDecimal getCompanyCost(String companyName);
}
