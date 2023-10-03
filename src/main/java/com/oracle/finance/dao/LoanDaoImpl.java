package com.oracle.finance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
