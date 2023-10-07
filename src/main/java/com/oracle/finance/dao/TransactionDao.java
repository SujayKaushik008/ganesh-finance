package com.oracle.finance.dao;

import java.util.List;

import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanBalance;
import com.oracle.finance.entity.Transaction;

public interface TransactionDao {
	public void insertIntoTransactionTable(Transaction transaction);
	public void editLoanBalanceTable(LoanBalance loanBalance);
	public void closeLoan(String loan_account_number);
	public List<LoanAccountBalance> getAllActiveLoans();
}
