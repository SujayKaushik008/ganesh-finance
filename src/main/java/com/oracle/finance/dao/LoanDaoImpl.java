package com.oracle.finance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanType;


@Component
public class LoanDaoImpl implements LoanDao{

	@Autowired
	DBConnection dbConnection;

	@Override
	public List<LoanType> getLoanTypes() {
		Connection con=	dbConnection.connect();
		List<LoanType> resultList = new ArrayList<>();
		try {
			String sql="select * from loantype";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();

			while( rs.next()) {
				int loan_type_code = rs.getInt("loan_type_code");
				String loan_type_name = rs.getString("loan_type_name");
				float interest_rate = rs.getFloat("interest_rate");

				LoanType loanType = new LoanType(loan_type_code,loan_type_name,interest_rate);

				resultList.add(loanType);
			}
//			TODO: handle the else appropiately
//			else {
//				System.out.println("loan types not found !!!!");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

	@Override
	public List<LoanApplication> getAllLoanApplication() {
		Connection con=	dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql="select * from loan_application";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();

			while( rs.next()) {
				

				LoanApplication loanApplication = new LoanApplication();
				
				loanApplication.setApplication_date(rs.getDate(8));
				loanApplication.setApplication_status(rs.getInt(7));
				loanApplication.setClerk_id(rs.getString(2));
				loanApplication.setCustomer_id(rs.getString(4));
				loanApplication.setLoan_application_number(rs.getString(1));
				loanApplication.setLoan_tenure(rs.getInt(6));
				loanApplication.setLoan_type(rs.getInt(3));
				loanApplication.setRequested_amount(rs.getFloat(5));
				loanApplication.setRoi(rs.getFloat(9));
				
				

				resultList.add(loanApplication);
			}
//			TODO: handle the else appropiately
//			else {
//				System.out.println("loan types not found !!!!");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
		}

	@Override
	public LoanApplication applyLoan(LoanApplication a) {
		Connection con=	dbConnection.connect();
		try {
			
			
			String application_number=UUID.randomUUID().toString();	
			
			Date application_date = new Date(System.currentTimeMillis());
			String query="INSERT INTO LOAN_APPLICATION VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,application_number);
			ps.setString(2,a.getClerk_id());
			ps.setInt(3,a.getLoan_type());
			ps.setString(4,a.getCustomer_id());
			ps.setFloat(5, a.getRequested_amount());
			ps.setInt(6,a.getLoan_tenure());
			ps.setInt(7,a.getApplication_status());
			ps.setDate(8,application_date );
			ps.setFloat(9,a.getRoi());
			
			int res=ps.executeUpdate();
			System.out.println("sss"+res);
			a.setApplication_date(application_date);
			a.setLoan_application_number(application_number);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}

}
