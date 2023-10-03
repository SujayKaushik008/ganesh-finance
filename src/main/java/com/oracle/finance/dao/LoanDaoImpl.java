package com.oracle.finance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
