package com.oracle.finance.service;

import java.util.List;
import java.util.Map;

import com.oracle.finance.entity.ApproveLoanRequest;
import com.oracle.finance.entity.ApproveLoanResponse;
import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanCancellationRequest;
import com.oracle.finance.entity.LoanType;

public interface LoanService {
	public List<LoanType> getLoanTypesService();
	public List<LoanApplication> getAllLoanApplicationService();
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date);
	public LoanApplication searchLoanApplicationByNumberService(String loan_application_number);
	public List<LoanApplication> searchLoanApplicationByTypeService(int type_code);
	public List<LoanApplication> searchLoanApplicationByCustomerIdService(String customer_id);
	public List<LoanApplication> searchLoanApplicationByBranchService(String Branch_code);

	public LoanApplication applyLoan(LoanApplication a);
	public ApproveLoanResponse approveLoan(ApproveLoanRequest approveLoanRequest);
	public Map<String,String> cancelLoanService(LoanCancellationRequest loanCancellationRequest);
}
