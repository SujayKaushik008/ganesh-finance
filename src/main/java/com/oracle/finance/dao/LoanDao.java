package com.oracle.finance.dao;

import java.util.List;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;

public interface LoanDao {
	 public List<LoanType> getLoanTypes();
	 public List<LoanApplication> getAllLoanApplication();
	 public LoanApplication searchLoanApplicationByDate(String start_date, String end_date);
	 public LoanApplication searchLoanApplicationByNumber(String loan_application_number);
	 public LoanApplication searchLoanApplicationByType(int type_code);
	 
}
