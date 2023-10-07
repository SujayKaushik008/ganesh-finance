package com.oracle.finance.entity;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class LoanApplication {
	private String loan_application_number,clerk_id,customer_id;
	private int loan_type,application_status,loan_tenure;
	private Date application_date;
	private float roi,requested_amount;
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public LoanApplication() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LoanApplication(String loan_application_number, String clerk_id, String customer_id, int loan_type,
			int application_status, int loan_tenure, Date application_date, float roi, float requested_amount,
			MultipartFile file) {
		super();
		this.loan_application_number = loan_application_number;
		this.clerk_id = clerk_id;
		this.customer_id = customer_id;
		this.loan_type = loan_type;
		this.application_status = application_status;
		this.loan_tenure = loan_tenure;
		this.application_date = application_date;
		this.roi = roi;
		this.requested_amount = requested_amount;
		this.file = file;
	}

//	public LoanApplication(String loan_application_number, String clerk_id, String customer_id, int loan_tenure,
//			int loan_type, int application_status, float roi, float requested) {
//		super();
//		this.loan_application_number = loan_application_number;
//		this.clerk_id = clerk_id;
//		this.customer_id = customer_id;
//		this.loan_tenure = loan_tenure;
//		this.loan_type = loan_type;
//		this.application_status = application_status;
//		this.roi = roi;
//		this.requested_amount = requested;
//	}

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

	public int getLoan_tenure() {
		return loan_tenure;
	}

	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
	}

	public int getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(int loan_type) {
		this.loan_type = loan_type;
	}

	public float getRequested_amount() {
		return requested_amount;
	}

	public void setRequested_amount(float requested_amount) {
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

	public float getRoi() {
		return roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}
	
	
}
