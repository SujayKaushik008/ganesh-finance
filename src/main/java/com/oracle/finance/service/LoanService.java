package com.oracle.finance.service;

import java.util.List;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;

public interface LoanService {
	public List<LoanType> getLoanTypesService();
	public List<LoanApplication> getAllLoanApplicationService();
	public LoanApplication applyLoan(LoanApplication a);
}
