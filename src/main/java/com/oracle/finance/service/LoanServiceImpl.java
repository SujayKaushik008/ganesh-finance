package com.oracle.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.LoanDao;
import com.oracle.finance.entity.ApproveLoanRequest;
import com.oracle.finance.entity.ApproveLoanResponse;
import com.oracle.finance.entity.LoanAccount;
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
			if(result.size() == 0) throw new ApplicationException()	;
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
			if(result.size() == 0) throw new ApplicationException()	;
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
			if(result.size() == 0) throw new ApplicationException()	;
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

@Override
public ApproveLoanResponse approveLoan(ApproveLoanRequest approveLoanRequest) {

	int ApprovalCode = approveLoanRequest.getApprovalCode()	;
	ApproveLoanResponse approveLoanResponse = new ApproveLoanResponse()	;
	approveLoanResponse.setApprovalCode(ApprovalCode);
	if(ApprovalCode == 1) {
		LoanAccount loanAccount = new LoanAccount();
		loanAccount.setCustomer_id(approveLoanRequest.getCustomer_id());
		loanAccount.setDisbursed_amount(approveLoanRequest.getDisbursed_amount());
		loanAccount.setEmi(approveLoanRequest.getEmi());
		loanAccount.setLoan_application_number(approveLoanRequest.getLoan_application_number());
		loanAccount.setLoan_status(approveLoanRequest.getLoan_status());
		loanAccount.setLoan_tenure(approveLoanRequest.getLoan_tenure());
		loanAccount.setLoan_type_code(approveLoanRequest.getLoan_type_code());
		loanAccount.setManager_id(approveLoanRequest.getManager_id());
		loanAccount.setRoi(approveLoanRequest.getRoi());
		loanAccount.setSanctioned_amount(approveLoanRequest.getSanctioned_amount());
		approveLoanResponse.setLoanAccount(loanDao.approveLoan(loanAccount));
		
	}else {
		loanDao.rejectLoan(approveLoanRequest.getLoan_application_number());
	}
	return approveLoanResponse;
}

}
