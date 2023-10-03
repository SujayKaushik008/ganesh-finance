package com.oracle.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.LoanDao;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;

@Component
public class LoanServiceImpl implements LoanService{


	@Autowired
	public LoanDao loanDao;
	
	@Override
	public List<LoanType> getLoanTypesService() {
		return loanDao.getLoanTypes();
	}

	@Override
	public List<LoanApplication> getAllLoanApplicationService() {
		return loanDao.getAllLoanApplication();
	}

	@Override
	public LoanApplication applyLoan(LoanApplication a) {
		
		return loanDao.applyLoan(a);
	}

}
