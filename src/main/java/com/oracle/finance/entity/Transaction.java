package com.oracle.finance.entity;

import java.sql.Date;

public class Transaction {
	private String transaction_id,loan_account_number;
	private float transaction_amount;
	private Date date_of_transaction;
	public Transaction(String transaction_id, String loan_account_number, float transaction_amount,
			Date date_of_transaction) {
		super();
		this.transaction_id = transaction_id;
		this.loan_account_number = loan_account_number;
		this.transaction_amount = transaction_amount;
		this.date_of_transaction = date_of_transaction;
	}
	
	
	
	public Transaction() {
		super();
	}



	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getLoan_account_number() {
		return loan_account_number;
	}
	public void setLoan_account_number(String loan_account_number) {
		this.loan_account_number = loan_account_number;
	}
	public float getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public Date getDate_of_transaction() {
		return date_of_transaction;
	}
	public void setDate_of_transaction(Date date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}
	
	
}
