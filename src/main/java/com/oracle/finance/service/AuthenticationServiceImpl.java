package com.oracle.finance.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.AuthenticationDao;
import com.oracle.finance.entity.LoginResponse;
import com.oracle.finance.entity.Users;
@Component
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	public AuthenticationDao authenticationdao;
	
	@Override
	public LoginResponse getUserDetails(Users u) {
		
		return authenticationdao.getUserDetails(u);
	}


	@Override
	public Map<String, String> getCustomerIdByUserName(String cust_user_name) {
		return authenticationdao.getCustomerIdByUserName(cust_user_name);
	}



}
