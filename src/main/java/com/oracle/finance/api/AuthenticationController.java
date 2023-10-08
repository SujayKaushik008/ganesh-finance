package com.oracle.finance.api;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.finance.entity.LoginResponse;
import com.oracle.finance.entity.Users;
import com.oracle.finance.service.AuthenticationService;


@RestController
@CrossOrigin

public class AuthenticationController {

		@Autowired
		AuthenticationService authenticationservice;
		
		
		@PostMapping("/Authentication/login")
		public LoginResponse getUserDetails(@RequestBody Users u)
		{
			return authenticationservice.getUserDetails(u);
		}
		
		
		@GetMapping("/Authentication/customer/{cust_username}")
		public Map<String,String> getCustomerIdByUserName(@PathVariable String cust_username) {
			return authenticationservice.getCustomerIdByUserName(cust_username);
		}
}
