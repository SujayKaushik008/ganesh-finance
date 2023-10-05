package com.oracle.finance.service;

import java.util.Map;

import com.oracle.finance.entity.LoginResponse;
import com.oracle.finance.entity.Users;

public interface AuthenticationService {
	public LoginResponse getUserDetails(Users u);
	public Map<String,String> getCustomerIdByUserName(String cust_user_name);
}
