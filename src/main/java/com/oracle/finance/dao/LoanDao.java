package com.oracle.finance.dao;

import java.util.List;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;

public interface LoanDao {
	 public List<LoanType> getLoanTypes();
	 public List<LoanApplication> getAllLoanApplication();

	 public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date);
	 public List<LoanApplication> searchLoanApplicationByNumber(String loan_application_number);
	 public List<LoanApplication> searchLoanApplicationByType(int type_code);
	 
	 public LoanApplication applyLoan(LoanApplication a);
}
