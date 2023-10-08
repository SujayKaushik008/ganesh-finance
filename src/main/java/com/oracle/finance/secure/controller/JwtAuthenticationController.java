package com.oracle.finance.secure.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.oracle.finance.secure.config.JwtTokenUtil;
import com.oracle.finance.secure.model.JwtRequest;
import com.oracle.finance.secure.model.JwtResponse;
import com.oracle.finance.secure.model.UserDto;
import com.oracle.finance.secure.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("Loaded .. ");
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("Toekn generated .. ");

		 String roles=userDetailsService.getRoles();
		 
		 String userName=userDetailsService.getUserName();
		 String empcustid = userDetailsService.getEmpcustid();
		 int userRole = userDetailsService.getUserRole();
		 String branchCode = userDetailsService.getBranchCode();
		 
		return ResponseEntity.ok(new JwtResponse(token,userRole,userName,empcustid,branchCode));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		System.out.println("entered controller");
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e); 
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
