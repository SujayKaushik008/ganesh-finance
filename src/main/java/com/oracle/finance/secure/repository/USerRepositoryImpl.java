package com.oracle.finance.secure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.dao.DBConnection;
import com.oracle.finance.secure.model.User;
@Component
public class USerRepositoryImpl implements UserRepository {
	@Autowired
	DBConnection dbConnection;
	@Override
	public User findByUsername(String username) {
		Connection con=	dbConnection.connect();
		   User user=new User();
		 try {
	    	String sql="select * from users join where username=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
		    ResultSet rs= pstmt.executeQuery();
		 
		   if( rs.next()) {
			   System.out.println("user found .....");
		    String uname=rs.getString("username");
		    int role=rs.getInt("role");
		    String password=rs.getString("password");
		    String empcustid = rs.getString("empcustid");
		    user.setUsername(uname);
		    user.setRole(role);
		    user.setPassword(password);
		    user.setEmpcustid(empcustid);
		    
		    String sql1="";
		    if(role == 2) {
		    	sql1 = "select * from customer join where customer_id=?";
		    }else {
		    	sql1 = "select * from employee join where employee_id=?";
			}
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, empcustid);
		    ResultSet rs1= pstmt1.executeQuery();
		    if(rs1.next()) {
		    	String branchCode = rs1.getString(7);
				user.setBranchCode(branchCode);
		    } 
		    
		   }
		   else {
			   System.out.println("Customer record not found !!!!");
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    finally {
	    	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		 return user;
	}

	@Override
	public User save(User user) {

Connection con=	dbConnection.connect();

String empcustid = UUID.randomUUID().toString();
String sql="insert into users values(?,?,?,?)";
try {
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(4,empcustid);
	pstmt.setString(1, user.getUsername());
	pstmt.setString(2, user.getPassword());
	pstmt.setInt(3, user.getRole());
	int count=pstmt.executeUpdate();//query will get fired here...
	System.out.println(count+" no of row(s)s updated");
	
	
	if(user.getRole() == 2) {
		String sql2 = "insert into customer values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1,empcustid);
		pstmt2.setString(2,user.getFirstName());
		pstmt2.setString(3, user.getLastName());
		pstmt2.setInt(4,user.getGender());
		pstmt2.setString(5,user.getContact());
		pstmt2.setString(6,user.getEmail());
		pstmt2.setString(7,user.getBranchCode());
		pstmt2.setString(8,user.getAadhar());
		pstmt2.setString(9,user.getPan());
		int count2 = pstmt2.executeUpdate();
		user.setEmpcustid(empcustid);
		System.out.println(count2+" no of row(s)s updated");
		
	}else {
		String sql2 = "insert into employee values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1,empcustid);
		pstmt2.setString(2,user.getFirstName());
		pstmt2.setString(3, user.getLastName());
		pstmt2.setInt(4,user.getGender());
		pstmt2.setString(5,user.getContact());
		pstmt2.setString(6,user.getEmail());
		pstmt2.setString(7,user.getBranchCode());
		int count2 = pstmt2.executeUpdate();
		user.setEmpcustid(empcustid);
		System.out.println(count2+" no of row(s)s updated");
		
	}
	//con.close();//this code wont execute if any errors occured in try block

} catch (SQLException e) {
	e.printStackTrace();
}
//con.close(); //this code wont execute if any exception occured in catch block ....
finally {
	try {
		con.close();//executes in all scenarios 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

		return user;
	}

}
