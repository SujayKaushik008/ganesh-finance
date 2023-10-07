package com.oracle.finance.entity;

import java.sql.Date;

public class LoanapplicationDocument {
	private String loan_application_number,clerk_id,customer_id;
	private int loan_type,application_status,loan_tenure;
	private Date application_date;
	private float roi,requested_amount;
    private byte[] fileBytes;
    private String fileName;
    private String contentType;
    
    public LoanapplicationDocument() {
		// TODO Auto-generated constructor stub
	}

	public LoanapplicationDocument(String loan_application_number, String clerk_id, String customer_id, int loan_type,
			int application_status, int loan_tenure, Date application_date, float roi, float requested_amount,
			byte[] fileBytes, String fileName, String contentType) {
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
		this.fileBytes = fileBytes;
		this.fileName = fileName;
		this.contentType = contentType;
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

	public int getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(int loan_type) {
		this.loan_type = loan_type;
	}

	public int getApplication_status() {
		return application_status;
	}

	public void setApplication_status(int application_status) {
		this.application_status = application_status;
	}

	public int getLoan_tenure() {
		return loan_tenure;
	}

	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
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

	public float getRequested_amount() {
		return requested_amount;
	}

	public void setRequested_amount(float requested_amount) {
		this.requested_amount = requested_amount;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
    
}
