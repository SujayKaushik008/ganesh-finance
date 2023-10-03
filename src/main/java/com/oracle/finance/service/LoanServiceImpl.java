package com.oracle.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.LoanDao;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;
import com.oracle.finance.exception.ApplicationException;

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
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByDate(start_date, end_date);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new ApplicationException(msg);
		}
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByNumberService(String loan_application_number) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByNumber(loan_application_number);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new ApplicationException(msg);
		}
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByTypeService(int type_code) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByType(type_code);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new ApplicationException(msg);
		}
		return result;
	}

@Override
	public LoanApplication applyLoan(LoanApplication a) {
		
		return loanDao.applyLoan(a);
	}

}
