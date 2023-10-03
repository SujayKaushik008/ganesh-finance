package com.oracle.finance.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;
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
	public LoanApplication searchApplicationByDate(@PathVariable String start_date, @PathVariable String end_date){
		return loanService.searchLoanApplicationByDateService(start_date,end_date);
	}
	
	@GetMapping("/loanApplication/number/{loan_application_number}")
	public LoanApplication searchApplicationByNumber(@PathVariable String loan_application_number){
		return loanService.searchLoanApplicationByNumberService(loan_application_number);
	}
	
	@GetMapping("/loanApplication/type/{type_code}")
	public LoanApplication searchApplicationByType(@PathVariable int type_code){
		return loanService.searchLoanApplicationByTypeService(type_code);
	}

}
