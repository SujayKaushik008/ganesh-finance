package com.oracle.finance.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.oracle.finance.entity.ApproveLoanRequest;
import com.oracle.finance.entity.ApproveLoanResponse;
import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanAccountRequest;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanCancellationRequest;
import com.oracle.finance.entity.LoanType;
import com.oracle.finance.entity.LoanapplicationDocument;
import com.oracle.finance.entity.Transaction;

public interface LoanService {
	public List<LoanType> getLoanTypesService();
	public List<LoanApplication> getAllLoanApplicationService();
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date);
	public LoanApplication searchLoanApplicationByNumberService(String loan_application_number);
	public List<LoanApplication> searchLoanApplicationByTypeService(int type_code);
	public List<LoanApplication> searchLoanApplicationByCustomerIdService(String customer_id);
	public List<LoanApplication> searchLoanApplicationByBranchService(String Branch_code);
	public List<LoanAccount> getLoanAccount(LoanAccountRequest loanAccountRequest);
	public LoanAccountBalance getLoanAccountDetails(String loan_account_number);
	public LoanApplication applyLoan(LoanApplication a);
	public ApproveLoanResponse approveLoan(ApproveLoanRequest approveLoanRequest);
	public Map<String,String> cancelLoanService(LoanCancellationRequest loanCancellationRequest);
	public List<Transaction> getLoanAccountTransactionService(String loan_account_number);
	public LoanApplication applyloan2(MultipartFile file, String clerk_id, String customerid, String customerid2, int loantype,
			int applicationstatus, int loantenure, float roi, float requestedamount);
	public LoanapplicationDocument searchLoanApplicationByNumberService2(String loan_application_number);
	
}
