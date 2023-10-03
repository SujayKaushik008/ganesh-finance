package com.oracle.finance.entity;

import java.sql.Date;

public class LoanApplication {
	private String loan_application_number,clerk_id,customer_id,loan_tenure;
	private int loan_type,requested_amount,application_status;
	private Date application_date;
	
	public LoanApplication() {
		// TODO Auto-generated constructor stub
	}
	
	public LoanApplication(String loan_application_number, String clerk_id, String customer_id, String loan_tenure,
			int loan_type, int requested_amount, int application_status, Date application_date) {
		super();
		this.loan_application_number = loan_application_number;
		this.clerk_id = clerk_id;
		this.customer_id = customer_id;
		this.loan_tenure = loan_tenure;
		this.loan_type = loan_type;
		this.requested_amount = requested_amount;
		this.application_status = application_status;
		this.application_date = application_date;
	}

	public String getLoan_application_number() {
		return loan_application_number;
	}

	public void setLoan_application_number(String loan_application_number) {
		this.loan_application_number = loan_application_number;
	}

	public String getClerk_id() {
		return clerk_id;
	}

	public void setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getLoan_tenure() {
		return loan_tenure;
	}

	public void setLoan_tenure(String loan_tenure) {
		this.loan_tenure = loan_tenure;
	}

	public int getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(int loan_type) {
		this.loan_type = loan_type;
	}

	public int getRequested_amount() {
		return requested_amount;
	}

	public void setRequested_amount(int requested_amount) {
		this.requested_amount = requested_amount;
	}

	public int getApplication_status() {
		return application_status;
	}

	public void setApplication_status(int application_status) {
		this.application_status = application_status;
	}

	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}
	
	
}
