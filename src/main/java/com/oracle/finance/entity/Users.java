package com.oracle.finance.entity;

public class Users {
	private String username,password,role,empcustid;
	
	public Users() {

	}

	public Users(String username, String password, String role, String empcustid) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.empcustid = empcustid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpcustid() {
		return empcustid;
	}

	public void setEmpcustid(String empcustid) {
		this.empcustid = empcustid;
	}
	
}
