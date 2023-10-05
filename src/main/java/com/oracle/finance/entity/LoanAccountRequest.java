package com.oracle.finance.entity;

public class LoanAccountRequest {
	private int role;
	private String branch_code;
	private String id;
	public LoanAccountRequest(int role, String branch_code, String id) {
		super();
		this.role = role;
		this.branch_code = branch_code;
		this.id = id;
	}
	public LoanAccountRequest() {
		super();
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
