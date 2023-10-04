package com.oracle.finance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.entity.Users;
import com.oracle.finance.exception.ApplicationException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	DBConnection dbConnection;
	
	@Override
	public Users getUserDetails(Users u) {
		
		Connection con=dbConnection.connect();
		Users user= new Users();
		String query ="select * from users where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmpcustid(rs.getString(4));
				user.setRole(rs.getInt(3));
			}
			else
			{
				throw new ApplicationException("Invalid Credentials");
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
		
		return user;
	}
	
}
