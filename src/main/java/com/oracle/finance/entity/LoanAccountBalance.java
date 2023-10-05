package com.oracle.finance.entity;

import java.sql.Date;

public class LoanAccountBalance {
	private int tenure_remaining,overdue;
	private float outstanding_balance,priciple_paid,interest_paid;
	private String loan_account_number,customer_id,manager_id,loan_application_number;
	private int loan_type_code,loan_status,loan_tenure;
	private float disbursed_amount,sanctioned_amount,emi,roi;
	private Date approval_date;

	
	public LoanAccountBalance(int tenure_remaining, int overdue, float outstanding_balance, float priciple_paid,
			float interest_paid, String loan_account_number, String customer_id, String manager_id,
			String loan_application_number, int loan_type_code, int loan_status, int loan_tenure,
			float disbursed_amount, float sanctioned_amount, float emi, float roi, Date approval_date) {
		super();
		this.tenure_remaining = tenure_remaining;
		this.overdue = overdue;
		this.outstanding_balance = outstanding_balance;
		this.priciple_paid = priciple_paid;
		this.interest_paid = interest_paid;
		this.loan_account_number = loan_account_number;
		this.customer_id = customer_id;
		this.manager_id = manager_id;
		this.loan_application_number = loan_application_number;
		this.loan_type_code = loan_type_code;
		this.loan_status = loan_status;
		this.loan_tenure = loan_tenure;
		this.disbursed_amount = disbursed_amount;
		this.sanctioned_amount = sanctioned_amount;
		this.emi = emi;
		this.roi = roi;
		this.approval_date = approval_date;
	}
	
	
	
	public float getInterest_paid() {
		return interest_paid;
	}



	public void setInterest_paid(float interest_paid) {
		this.interest_paid = interest_paid;
	}



	public LoanAccountBalance() {
		super();
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
	public String getLoan_account_number() {
		return loan_account_number;
	}
	public void setLoan_account_number(String loan_account_number) {
		this.loan_account_number = loan_account_number;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getLoan_application_number() {
		return loan_application_number;
	}
	public void setLoan_application_number(String loan_application_number) {
		this.loan_application_number = loan_application_number;
	}
	public int getLoan_type_code() {
		return loan_type_code;
	}
	public void setLoan_type_code(int loan_type_code) {
		this.loan_type_code = loan_type_code;
	}
	public int getLoan_status() {
		return loan_status;
	}
	public void setLoan_status(int loan_status) {
		this.loan_status = loan_status;
	}
	public int getLoan_tenure() {
		return loan_tenure;
	}
	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
	}
	public float getDisbursed_amount() {
		return disbursed_amount;
	}
	public void setDisbursed_amount(float disbursed_amount) {
		this.disbursed_amount = disbursed_amount;
	}
	public float getSanctioned_amount() {
		return sanctioned_amount;
	}
	public void setSanctioned_amount(float sanctioned_amount) {
		this.sanctioned_amount = sanctioned_amount;
	}
	public float getEmi() {
		return emi;
	}
	public void setEmi(float emi) {
		this.emi = emi;
	}
	public float getRoi() {
		return roi;
	}
	public void setRoi(float roi) {
		this.roi = roi;
	}
	public Date getApproval_date() {
		return approval_date;
	}
	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}
	
	

}
