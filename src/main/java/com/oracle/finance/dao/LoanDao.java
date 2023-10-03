package com.oracle.finance.dao;

import java.util.List;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;

public interface LoanDao {
	 public List<LoanType> getLoanTypes();
	 public List<LoanApplication> getAllLoanApplication();
	 
}
