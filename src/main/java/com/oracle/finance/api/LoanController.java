package com.oracle.finance.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
