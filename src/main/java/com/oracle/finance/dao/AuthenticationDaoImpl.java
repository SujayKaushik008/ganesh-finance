package com.oracle.finance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.entity.LoginResponse;
import com.oracle.finance.entity.Users;
import com.oracle.finance.exception.ApplicationException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@Component
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	DBConnection dbConnection;
	
	@Override
	public LoginResponse getUserDetails(Users u) {
		
		Connection con=dbConnection.connect();
		LoginResponse loginResponse= new LoginResponse();
		String query ="select * from users where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				
				loginResponse.setUsername(rs.getString(1));
				loginResponse.setPassword(rs.getString(2));
				loginResponse.setEmpcustid(rs.getString(4));
				loginResponse.setRole(rs.getInt(3));
			}else
			{
				System.out.println("poiunt3");
				throw new ApplicationException("Invalid Credentials");
			}
			
			System.out.println(loginResponse.getRole());
			
			if(loginResponse.getRole() == 2) {
				System.out.println("in cust part");
				String query2 = "select * from customer where customer_id = ?";
				PreparedStatement ps2 = con.prepareStatement(query2);
				ps2.setString(1, loginResponse.getEmpcustid());
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					loginResponse.setBranchCode(rs2.getString(7));
				}else {
					throw new ApplicationException("SQL issue");
				}
				
			}else {

				System.out.println("in emp part");
				String query2 = "select * from employee where employee_id = ?";
				PreparedStatement ps2 = con.prepareStatement(query2);
				System.out.println(loginResponse.getEmpcustid());
				ps2.setString(1, loginResponse.getEmpcustid());
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					loginResponse.setBranchCode(rs2.getString(7));
				}else {
					throw new ApplicationException("SQL issue");
				}
			
			}
		
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return loginResponse;
	}

	@Override
	public Map<String, String> getCustomerIdByUserName(String cust_username) {
		Map<String,String> response = new HashMap<>();
		Connection con=dbConnection.connect();
		String query ="select empcustid from users where username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cust_username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.put("status", "success");
				response.put("customer_id", rs.getString(1));
			}else
			{
				response.put("status", "failure");	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return response;
		
		
	}
	
}
