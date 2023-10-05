package com.oracle.finance.dao;

import java.util.List;
import java.util.Map;

import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountRequest;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanCancellationRequest;
import com.oracle.finance.entity.LoanType;

public interface LoanDao {
	 public List<LoanType> getLoanTypes();
	 public List<LoanApplication> getAllLoanApplication();

	 public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date);
	 public LoanApplication searchLoanApplicationByNumber(String loan_application_number);
	 public List<LoanApplication> searchLoanApplicationByType(int type_code);
	 public List<LoanApplication> searchLoanApplicationByCustomerId(String customer_id);
	 public List<LoanApplication> searchLoanApplicationByBranch(String branch_code);
	 public List<LoanAccount> getLoanAccountsByCustomerId(String customer_id);
	 public List<LoanAccount> getLoanAccountsByBranch(String branch_code);
	 
	 public LoanApplication applyLoan(LoanApplication a);
	 public LoanAccount approveLoan(LoanAccount loanAccount);
	 public void rejectLoan(String loan_application_number);
	 public Map<String,String> cancelLoan(LoanCancellationRequest loanCancellationRequest);
}
