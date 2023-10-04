package com.oracle.finance.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.finance.entity.Users;
import com.oracle.finance.service.AuthenticationService;


@RestController
@CrossOrigin

public class AuthenticationController {

		@Autowired
		AuthenticationService authenticationservice;
		
		
		@PostMapping("/Authentication/login")
		public Users getUserDetails(@RequestBody Users u)
		{
			return authenticationservice.getUserDetails(u);
		}
}
