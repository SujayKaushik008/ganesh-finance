package com.oracle.finance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanBalance;
import com.oracle.finance.entity.Transaction;
import com.oracle.finance.exception.ApplicationException;
@Component
public class TransactionDaoImpl implements TransactionDao{

	@Autowired
	DBConnection dbConnection;


	@Override
	public void insertIntoTransactionTable(Transaction transaction) {
		Connection con=	dbConnection.connect();
		try {
			String query="INSERT INTO TRANSACTION VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,transaction.getTransaction_id());
			ps.setFloat(2,transaction.getTransaction_amount());
			ps.setString(3,transaction.getLoan_account_number());
			ps.setDate(4,transaction.getDate_of_transaction());

			int res=ps.executeUpdate();
			System.out.println(res + " rows are inserted");

		} catch (Exception e) {
			System.out.println(e);
		}
		finally { 
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

	@Override
	public void editLoanBalanceTable(LoanBalance loanBalance) {
		Connection con=	dbConnection.connect();
		try {
			String query="UPDATE LOAN_BALANCE SET INTEREST_PAID = ? , OUTSTANDING_BALANCE = ? , TENURE_REMAINING = ? , PRINCIPLE_PAID = ? , OVERDUE = ? WHERE LOAN_ACCOUNT_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println((float)Math.round(loanBalance.getInterest_paid() * 100.0) / 100.0);
			ps.setFloat(1,(float)Math.floor(loanBalance.getInterest_paid() * 100) / 100);
			ps.setFloat(2,(float)Math.floor(loanBalance.getOutstanding_balance() * 100) / 100);
			ps.setInt(3,loanBalance.getTenure_remaining());
			ps.setFloat(4,(float)Math.floor(loanBalance.getPriciple_paid() * 100) / 100);
			ps.setInt(5,loanBalance.getOverdue());
			ps.setString(6,loanBalance.getLoan_account_number());
			System.out.println(loanBalance.getInterest_paid() + " " + loanBalance.getOutstanding_balance() + " " +  loanBalance.getTenure_remaining() + " " +  loanBalance.getOverdue() + " " +  loanBalance.getPriciple_paid() + " " + loanBalance.getLoan_account_number());

			int res=ps.executeUpdate();
			System.out.println(res + " loan Balance updated");

		} catch (Exception e) {
			System.out.println(e);
		}
		finally { 
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeLoan(String loan_account_number) {
		Connection con=	dbConnection.connect();
		try {
			String query="UPDATE LOAN_ACCOUNT SET LOAN_STATUS = 1 WHERE LOAN_ACCOUNT_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,loan_account_number);

			int res=ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		finally { 
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<LoanAccountBalance> getAllActiveLoans() {
		Connection con = dbConnection.connect();
		List<LoanAccountBalance> result = new ArrayList<>();
		try {
			String sql = "select * from loan_account join loan_balance on (loan_account.loan_account_number = loan_balance.loan_account_number) where loan_account.loan_status =1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanAccountBalance loanAccountBalance = new LoanAccountBalance();
				loanAccountBalance.setLoan_account_number(rs.getString(1));
				loanAccountBalance.setApproval_date(rs.getDate(6));
				loanAccountBalance.setCustomer_id(rs.getString(2));
				loanAccountBalance.setDisbursed_amount(rs.getFloat(5));
				loanAccountBalance.setEmi(rs.getFloat(9));
				loanAccountBalance.setLoan_application_number(rs.getString(8));
				loanAccountBalance.setLoan_status(rs.getInt(10));
				loanAccountBalance.setLoan_tenure(rs.getInt(11));
				loanAccountBalance.setLoan_type_code(rs.getInt(4));
				loanAccountBalance.setManager_id(rs.getString(3));
				loanAccountBalance.setRoi(rs.getFloat(12));
				loanAccountBalance.setSanctioned_amount(rs.getFloat(7));
				loanAccountBalance.setInterest_paid(rs.getFloat(14));
				loanAccountBalance.setOutstanding_balance(rs.getFloat(15));
				loanAccountBalance.setTenure_remaining(rs.getInt(16));
				loanAccountBalance.setPriciple_paid(rs.getFloat(17));
				loanAccountBalance.setOverdue(rs.getInt(18));
				result.add(loanAccountBalance);

			}
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
		return result;		
	}

}
