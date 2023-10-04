package com.oracle.finance.entity;

public class LoanCancellationRequest {
	private String id;
	private String loan_application_id;
	private int role;
	public LoanCancellationRequest(String id, String loan_application_id, int role) {
		super();
		this.id = id;
		this.loan_application_id = loan_application_id;
		this.role = role;
	}
	public LoanCancellationRequest() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoan_application_id() {
		return loan_application_id;
	}
	public void setLoan_application_id(String loan_application_id) {
		this.loan_application_id = loan_application_id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	
}
