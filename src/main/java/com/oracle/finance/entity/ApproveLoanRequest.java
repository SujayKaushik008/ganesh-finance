package com.oracle.finance.entity;


public class ApproveLoanRequest {
	private int role;
	private int approvalCode;
	private String customer_id,manager_id,loan_application_number;
	private int loan_type_code,loan_status,loan_tenure;
	private float disbursed_amount,sanctioned_amount,emi,roi;
	
	
	public ApproveLoanRequest() {

	}
	public ApproveLoanRequest(int role, int approvalCode, String customer_id, String manager_id,
			String loan_application_number, int loan_type_code, int loan_status, int loan_tenure,
			float disbursed_amount, float sanctioned_amount, float emi, float roi) {
		super();
		this.role = role;
		this.approvalCode = approvalCode;
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
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(int approvalCode) {
		this.approvalCode = approvalCode;
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
	
	

	
	
}
