package com.oracle.finance.entity;

import java.sql.Date;

public class Loan_account {
	
	private String loan_account_number,customer_id,manager_id,loan_application_number;
	private int loan_type_code,disbursed_amount,sanctioned_amount,loan_status,loan_tenure,emi;
	
	private Date approval_date;

	public Loan_account(String loan_account_number, String customer_id, String manager_id,
			String loan_application_number, int loan_type_code, int disbursed_amount, int sanctioned_amount,
			int loan_status, int loan_tenure, int emi, Date approval_date) {
		super();
		this.loan_account_number = loan_account_number;
		this.customer_id = customer_id;
		this.manager_id = manager_id;
		this.loan_application_number = loan_application_number;
		this.loan_type_code = loan_type_code;
		this.disbursed_amount = disbursed_amount;
		this.sanctioned_amount = sanctioned_amount;
		this.loan_status = loan_status;
		this.loan_tenure = loan_tenure;
		this.emi = emi;
		this.approval_date = approval_date;
	}
	public Loan_account() {
		// TODO Auto-generated constructor stub
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
	public int getDisbursed_amount() {
		return disbursed_amount;
	}
	public void setDisbursed_amount(int disbursed_amount) {
		this.disbursed_amount = disbursed_amount;
	}
	public int getSanctioned_amount() {
		return sanctioned_amount;
	}
	public void setSanctioned_amount(int sanctioned_amount) {
		this.sanctioned_amount = sanctioned_amount;
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
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public Date getApproval_date() {
		return approval_date;
	}
	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}
	
	
	
}	
