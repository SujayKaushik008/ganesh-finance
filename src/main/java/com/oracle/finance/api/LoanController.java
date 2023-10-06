package com.oracle.finance.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.finance.entity.ApproveLoanRequest;
import com.oracle.finance.entity.ApproveLoanResponse;
import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanAccountRequest;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanCancellationRequest;
import com.oracle.finance.entity.LoanType;
import com.oracle.finance.entity.Transaction;
import com.oracle.finance.service.LoanService;

@RestController
@CrossOrigin
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	
	
	@RequestMapping("/test")
	public String testApi() {
		return "test successful";
	}
	
	@GetMapping("/loantype")
	public List<LoanType> getLoanType(){
		return loanService.getLoanTypesService();
	}
	
	@GetMapping("/loanApplication/all")
	public List<LoanApplication> getAllApplications(){
		return loanService.getAllLoanApplicationService();
	}
	
	@GetMapping("/loanApplication/date/{start_date}/{end_date}")
	public List<LoanApplication> searchApplicationByDate(@PathVariable String start_date, @PathVariable String end_date){
		return loanService.searchLoanApplicationByDateService(start_date,end_date);
	}
	
	@GetMapping("/loanApplication/number/{loan_application_number}")
	public LoanApplication searchApplicationByNumber(@PathVariable String loan_application_number){
		return loanService.searchLoanApplicationByNumberService(loan_application_number);
	}
	
	@GetMapping("/loanApplication/type/{type_code}")
	public List<LoanApplication> searchApplicationByType(@PathVariable int type_code){
		return loanService.searchLoanApplicationByTypeService(type_code);
	}

	@PostMapping("/loanApplication/apply")
	public LoanApplication applyLoan(@RequestBody LoanApplication a)
	{
		return loanService.applyLoan(a);
	}
	

	@PostMapping("/loanApplication/approve")
	public ApproveLoanResponse approveLoan(@RequestBody ApproveLoanRequest approveLoanRequest)
	{
		System.out.println("entered the api");
		return loanService.approveLoan(approveLoanRequest);
	}
	
	@PostMapping("/loanApplication/cancel")
	public Map<String, String> cancelLoan(@RequestBody LoanCancellationRequest loanCancellationRequest)
	{
		System.out.println("entered the api");
		return loanService.cancelLoanService(loanCancellationRequest);
	}
	
	@GetMapping("/loanApplication/customer/{customer_id}")
	public List<LoanApplication> searchApplicationByCustomerId(@PathVariable String customer_id){
		return loanService.searchLoanApplicationByCustomerIdService(customer_id);
	}
	@GetMapping("/loanApplication/branch/{branch_code}")
	public List<LoanApplication> searchApplicationByBranch(@PathVariable String branch_code){
		return loanService.searchLoanApplicationByBranchService(branch_code);
	}
	 
	@PostMapping("/loanAccount")
	public List<LoanAccount> getLoanAccounts(@RequestBody LoanAccountRequest loanAccountRequest){
		return loanService.getLoanAccount(loanAccountRequest);
	}
	
	@GetMapping("/loanAccount/{loan_account_number}")
	public LoanAccountBalance getLoanAccountDetails(@PathVariable String loan_account_number){
		return loanService.getLoanAccountDetails(loan_account_number);
	}
	
	@GetMapping("/transaction/{loan_account_number}")
	public List<Transaction> getLoanAccountTransaction(@PathVariable String loan_account_number){
		return loanService.getLoanAccountTransactionService(loan_account_number);
	}
	
	
	
	
	
}
