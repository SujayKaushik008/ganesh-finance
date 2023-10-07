package com.oracle.finance.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.LoanDao;
import com.oracle.finance.dao.TransactionDao;
import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanBalance;
import com.oracle.finance.entity.Transaction;

@Component
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public void payEmi() {
		List<LoanAccountBalance> loanAccountBalances = transactionDao.getAllActiveLoans();
		
		for(LoanAccountBalance loanAccountBalance : loanAccountBalances) {

//			creating transaction
			String transactionId = UUID.randomUUID().toString();
			Transaction transaction = new Transaction();
			transaction.setTransaction_id(transactionId);
			transaction.setDate_of_transaction(new Date(System.currentTimeMillis()));
			transaction.setLoan_account_number(loanAccountBalance.getLoan_account_number());
			transaction.setTransaction_amount(loanAccountBalance.getEmi());
			
//			inserting transaction into table
			transactionDao.insertIntoTransactionTable(transaction);
			
//			calculating interest and principle component of emi
			float interest_component = (loanAccountBalance.getOutstanding_balance() * loanAccountBalance.getEmi())/12;
			float principle_componenet = loanAccountBalance.getEmi() - interest_component;
			
//			updating Loan Balance
			LoanBalance loanBalance = new LoanBalance();
			loanBalance.setInterest_paid(loanAccountBalance.getInterest_paid()  + interest_component);
			loanBalance.setOutstanding_balance(loanAccountBalance.getOutstanding_balance() - principle_componenet);
			loanBalance.setLoan_account_number(loanAccountBalance.getLoan_account_number());
			loanBalance.setOverdue(0);
			loanBalance.setTenure_remaining(loanAccountBalance.getTenure_remaining() - 1);
			loanBalance.setPriciple_paid(principle_componenet + loanAccountBalance.getPriciple_paid()); 
			
//			updating loan Balance in the table
			transactionDao.editLoanBalanceTable(loanBalance);
			
//			close loan if paid completely
			if(loanBalance.getTenure_remaining() == 0) {
				transactionDao.closeLoan(loanBalance.getLoan_account_number());

			}
			
		}
		
		
	}

}
