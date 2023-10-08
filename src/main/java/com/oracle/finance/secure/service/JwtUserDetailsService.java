package com.oracle.finance.secure.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oracle.finance.secure.model.User;
import com.oracle.finance.secure.model.UserDto;
import com.oracle.finance.secure.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	private String roles;
	int userRole;
	private String userName;
	private String empcustid;
	private String branchCode;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String role = "admin";
		if(user.getRole() == 2) {
			role = "user";
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(role));
		System.out.println("Roles : "+roles);
		setRoles(roles.toString());
		setUserName(user.getUsername());
		setEmpcustid(user.getEmpcustid());
		setUserRole(user.getRole());
		setBranchCode(user.getBranchCode());
		System.out.println("****");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				roles);
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			//	new ArrayList<>());
	}
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	


	public String getBranchCode() {
		return branchCode;
	}


	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	public String getEmpcustid() {
		return empcustid;
	}


	public void setEmpcustid(String empcustid) {
		this.empcustid = empcustid;
	}

	public int getUserRole() {
		return userRole;
	}


	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
	
	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public User save(UserDto user) {
		User newUser = new User();
		System.out.println("entered save implementation");
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setEmail(user.getEmail());
		newUser.setBranchCode(user.getBranchCode());
		newUser.setContact(user.getContact());
		newUser.setFirstName(user.getFirstName());
		newUser.setGender(user.getGender());
		newUser.setLastName(user.getLastName());
		if(newUser.getRole() == 2) {
			newUser.setPan(user.getPan());
			newUser.setAadhar(user.getAadhar());			
		}
		return userDao.save(newUser);
	}
}