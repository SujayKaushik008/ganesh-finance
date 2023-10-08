package com.oracle.finance.entity;

public class LoanBalance {

	private String loan_account_number;
	private int tenure_remaining,overdue;
	private float outstanding_balance,priciple_paid,interest_paid;
	
	
	
	public LoanBalance() {
		
	}

	
	public LoanBalance(String loan_account_number, int tenure_remaining, int overdue, float outstanding_balance,
			float priciple_paid, float interest_paid) {
		super();
		this.loan_account_number = loan_account_number;
		this.tenure_remaining = tenure_remaining;
		this.overdue = overdue;
		this.outstanding_balance = outstanding_balance;
		this.priciple_paid = priciple_paid;
		this.interest_paid = interest_paid;
	}


	public float getInterest_paid() {
		return interest_paid;
	}


	public void setInterest_paid(float interest_paid) {
		this.interest_paid = interest_paid;
	}


	public String getLoan_account_number() {
		return loan_account_number;
	}
	public void setLoan_account_number(String loan_account_number) {
		this.loan_account_number = loan_account_number;
	}
	public int getTenure_remaining() {
		return tenure_remaining;
	}
	public void setTenure_remaining(int tenure_remaining) {
		this.tenure_remaining = tenure_remaining;
	}
	public int getOverdue() {
		return overdue;
	}
	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}
	public float getOutstanding_balance() {
		return outstanding_balance;
	}
	public void setOutstanding_balance(float outstanding_balance) {
		this.outstanding_balance = outstanding_balance;
	}
	public float getPriciple_paid() {
		return priciple_paid;
	}
	public void setPriciple_paid(float priciple_paid) {
		this.priciple_paid = priciple_paid;
	}
	
}
