package com.oracle.finance.entity;

public class LoanType {
	private String loan_type_code,loan_type_name,intrest_rate;
	public LoanType() {
		
	}
	
	
	public LoanType(String loan_type_code, String loan_type_name, String intrest_rate) {
		super();
		this.loan_type_code = loan_type_code;
		this.loan_type_name = loan_type_name;
		this.intrest_rate = intrest_rate;
	}


	public String getLoan_type_code() {
		return loan_type_code;
	}
	public void setLoan_type_code(String loan_type_code) {
		this.loan_type_code = loan_type_code;
	}
	public String getLoan_type_name() {
		return loan_type_name;
	}
	public void setLoan_type_name(String loan_type_name) {
		this.loan_type_name = loan_type_name;
	}
	public String getIntrest_rate() {
		return intrest_rate;
	}
	public void setIntrest_rate(String intrest_rate) {
		this.intrest_rate = intrest_rate;
	}
	
}
