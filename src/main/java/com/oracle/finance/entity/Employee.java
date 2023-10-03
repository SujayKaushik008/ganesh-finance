package com.oracle.finance.entity;
import java.sql.*;
public class Employee {
	private String employee_id,employee_first_name,employee_last_name,contact,email,branch_code;
	private int gender;
	public Employee(String employee_id, String employee_first_name, String employee_last_name, int gender,
			String contact, String email, String branch_code) {
		super();
		this.employee_id = employee_id;
		this.employee_first_name = employee_first_name;
		this.employee_last_name = employee_last_name;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.branch_code = branch_code;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_first_name() {
		return employee_first_name;
	}

	public void setEmployee_first_name(String employee_first_name) {
		this.employee_first_name = employee_first_name;
	}

	public String getEmployee_last_name() {
		return employee_last_name;
	}

	public void setEmployee_last_name(String employee_last_name) {
		this.employee_last_name = employee_last_name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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
	
	

}
