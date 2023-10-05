package com.oracle.finance.dao;

import java.util.Map;

import com.oracle.finance.entity.LoginResponse;
import com.oracle.finance.entity.Users;

public interface AuthenticationDao{
	public LoginResponse getUserDetails(Users u);
	public Map<String,String> getCustomerIdByUserName (String cust_username);
}
