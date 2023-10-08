package com.oracle.finance.secure.model;


import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
    private int role;
    private String userName;
    private String empcustid;
    private String branchCode;
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public JwtResponse(String jwttoken, int role) {
		this.jwttoken = jwttoken;
		this.role = role;
	}

	
	public JwtResponse(String jwttoken, int role, String userName, String empcustid, String branchCode) {
		super();
		this.jwttoken = jwttoken;
		this.role = role;
		this.userName = userName;
		this.empcustid = empcustid;
		this.branchCode = branchCode;
	}
	
	
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getEmpcustid() {
		return this.empcustid;
	}
	public String getToken() {
		return this.jwttoken;
	}

	public int getRole() {
		return role;
	}
	public String getUserName() {
		return userName;
	}
	
}