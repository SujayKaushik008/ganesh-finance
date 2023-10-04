package com.oracle.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.AuthenticationDao;
import com.oracle.finance.entity.Users;
@Component
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	public AuthenticationDao authenticationdao;
	
	@Override
	public Users getUserDetails(Users u) {
		
		return authenticationdao.getUserDetails(u);
	}

}
