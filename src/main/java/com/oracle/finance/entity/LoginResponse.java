package com.oracle.finance.entity;

public class LoginResponse {
	private String username,password,empcustid;
	private int role;
	private String branchCode;
	public LoginResponse(String usersname, String password, String empcustid, int role, String branchCode) {
		super();
		this.username = usersname;
		this.password = password;
		this.empcustid = empcustid;
		this.role = role;
		this.branchCode = branchCode;
	}
	public LoginResponse() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usersname) {
		this.username = usersname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpcustid() {
		return empcustid;
	}
	public void setEmpcustid(String empcustid) {
		this.empcustid = empcustid;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
}
