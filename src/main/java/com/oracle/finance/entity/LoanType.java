package com.oracle.finance.entity;

public class LoanType {
	private int loan_type_code;
	private String loan_type_name;
	private float intrest_rate;
	public LoanType() {
		
	}
	
	
	public LoanType(int loan_type_code, String loan_type_name, float intrest_rate) {
		super();
		this.loan_type_code = loan_type_code;
		this.loan_type_name = loan_type_name;
		this.intrest_rate = intrest_rate;
	}


	public int getLoan_type_code() {
		return loan_type_code;
	}
	public void setLoan_type_code(int loan_type_code) {
		this.loan_type_code = loan_type_code;
	}
	public String getLoan_type_name() {
		return loan_type_name;
	}
	public void setLoan_type_name(String loan_type_name) {
		this.loan_type_name = loan_type_name;
	}
	public float getIntrest_rate() {
		return intrest_rate;
	}
	public void setIntrest_rate(float intrest_rate) {
		this.intrest_rate = intrest_rate;
	}
	
}
