package com.oracle.finance.entity;

public class Customer {
	private String customer_id,customer_first_name,customer_last_name,gender,contact,email,branch_code,aadhar_number,pan_umber;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String customer_id, String customer_first_name, String customer_last_name, String gender,
			String contact, String email, String branch_code, String aadhar_number, String pan_umber) {
		super();
		this.customer_id = customer_id;
		this.customer_first_name = customer_first_name;
		this.customer_last_name = customer_last_name;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.branch_code = branch_code;
		this.aadhar_number = aadhar_number;
		this.pan_umber = pan_umber;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_first_name() {
		return customer_first_name;
	}
	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}
	public String getCustomer_last_name() {
		return customer_last_name;
	}
	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	public String getPan_umber() {
		return pan_umber;
	}
	public void setPan_umber(String pan_umber) {
		this.pan_umber = pan_umber;
	}
	
	
}
