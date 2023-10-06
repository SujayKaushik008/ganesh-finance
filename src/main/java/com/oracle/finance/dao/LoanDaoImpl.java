package com.oracle.finance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountBalance;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.entity.LoanCancellationRequest;
import com.oracle.finance.entity.LoanType;
import com.oracle.finance.exception.ApplicationException;


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

	public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date) {
		System.out.println(start_date);
		System.out.println(end_date); 

		Date startDate = Date.valueOf(start_date);
		Date endDate = Date.valueOf(end_date);

		Connection con = dbConnection.connect();
		List<LoanApplication> result = new ArrayList<>();
		try {
			String sql = "select * from loan_application where application_date between ? and ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
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
				result.add(loanApplication);
			}
			//			else {
			//				throw new ApplicationException();
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
		return result;
	}

	@Override
	public LoanApplication searchLoanApplicationByNumber(String loan_application_number) {
		Connection con = dbConnection.connect();
		LoanApplication loanApplication = new LoanApplication();

		try {
			String sql = "select * from loan_application where loan_application_number =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_application_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				loanApplication.setApplication_date(rs.getDate(8));
				loanApplication.setApplication_status(rs.getInt(7));
				loanApplication.setClerk_id(rs.getString(2));
				loanApplication.setCustomer_id(rs.getString(4));
				loanApplication.setLoan_application_number(rs.getString(1));
				loanApplication.setLoan_tenure(rs.getInt(6));
				loanApplication.setLoan_type(rs.getInt(3));
				loanApplication.setRequested_amount(rs.getFloat(5));
				loanApplication.setRoi(rs.getFloat(9));
			}
			else {
				throw new ApplicationException("No applicaton found");
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
		return loanApplication;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByType(int type_code) {
		Connection con = dbConnection.connect();
		List<LoanApplication> result = new ArrayList<>();
		try {
			String sql = "select * from loan_application where loan_type_code =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, type_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
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
				result.add(loanApplication);
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
				e.printStackTrace();
			}
		}

		return a;
	}

	@Override
	public LoanAccount approveLoan(LoanAccount loanAccount) {
		Connection con=	dbConnection.connect();
		try {
			System.out.println("we have reached point 1");
			String query0="UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = 1 WHERE LOAN_APPLICATION_NUMBER = ?";
			PreparedStatement ps0 = con.prepareStatement(query0);
			ps0.setString(1,loanAccount.getLoan_application_number());

			System.out.println("we have reached point 2");

			String accountNumber = UUID.randomUUID().toString();	

			Date approval_date = new Date(System.currentTimeMillis());
			String query="INSERT INTO LOAN_ACCOUNT VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,accountNumber);
			ps.setString(2,loanAccount.getCustomer_id());
			ps.setString(3,loanAccount.getManager_id());
			ps.setInt(4,loanAccount.getLoan_type_code());
			ps.setFloat(5, loanAccount.getDisbursed_amount());
			ps.setDate(6,approval_date);
			ps.setFloat(7,loanAccount.getSanctioned_amount());
			ps.setString(8,loanAccount.getLoan_application_number() );
			ps.setFloat(9,loanAccount.getEmi());
			ps.setInt(10,loanAccount.getLoan_status());
			ps.setInt(11,loanAccount.getLoan_tenure() );
			ps.setFloat(12,loanAccount.getRoi());


			System.out.println("we have reached point 3");

			String query2="INSERT INTO LOAN_BALANCE VALUES(?,?,?,?,?,?)";
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setString(1,accountNumber);
			ps2.setFloat(2,0f);
			ps2.setFloat(3,loanAccount.getSanctioned_amount());
			ps2.setInt(4,loanAccount.getLoan_tenure());
			ps2.setFloat(5, 0f);
			ps2.setInt(6,0);

			int res=ps0.executeUpdate();
			res=ps.executeUpdate();
			ps2.executeUpdate();
			System.out.println("sss"+res);
			loanAccount.setLoan_account_number(accountNumber);
			loanAccount.setApproval_date(approval_date);

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

		return loanAccount;
	}

	@Override
	public void rejectLoan(String loan_application_number) {
		Connection con=	dbConnection.connect();
		try {

			String query="UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = 2 WHERE LOAN_APPLICATION_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,loan_application_number);
			int res=ps.executeUpdate();
			System.out.println("sss"+res);

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
	public Map<String, String> cancelLoan(LoanCancellationRequest loanCancellationRequest) {
		Connection con=	dbConnection.connect();
		Map <String, String> result = new HashMap<>();
		try {

			String query="UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = 3 WHERE LOAN_APPLICATION_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,loanCancellationRequest.getLoan_application_id());
			int res=ps.executeUpdate();
			System.out.println("sss"+res);
			result.put("result","success");

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
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByCustomerId(String customer_id) {
		Connection con = dbConnection.connect();
		List<LoanApplication> result = new ArrayList<>();
		try {
			String sql = "select * from loan_application where customer_id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
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
				result.add(loanApplication);
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
		System.out.println(result.size());
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByBranch(String branch_code) {
		Connection con = dbConnection.connect();
		List<LoanApplication> result = new ArrayList<>();
		try {
			String sql = "select * from loan_application join customer on(loan_application.customer_id = customer.customer_id) where customer.branch_code=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, branch_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
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
				result.add(loanApplication);
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

	@Override
	public List<LoanAccount> getLoanAccountsByCustomerId(String customer_id) {
		Connection con = dbConnection.connect();
		List<LoanAccount> result = new ArrayList<>();
		try {
			String sql = "select * from loan_account where customer_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanAccount loanAccount = new LoanAccount();
				loanAccount.setLoan_account_number(rs.getString(1));
				loanAccount.setApproval_date(rs.getDate(6));
				loanAccount.setCustomer_id(rs.getString(2));
				loanAccount.setDisbursed_amount(rs.getFloat(5));
				loanAccount.setEmi(rs.getFloat(9));
				loanAccount.setLoan_application_number(rs.getString(8));
				loanAccount.setLoan_status(rs.getInt(10));
				loanAccount.setLoan_tenure(rs.getInt(11));
				loanAccount.setLoan_type_code(rs.getInt(4));
				loanAccount.setManager_id(rs.getString(3));
				loanAccount.setRoi(rs.getFloat(12));
				loanAccount.setSanctioned_amount(rs.getFloat(7));

				result.add(loanAccount);
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

	@Override
	public List<LoanAccount> getLoanAccountsByBranch(String branch_code) {
		Connection con = dbConnection.connect();
		List<LoanAccount> result = new ArrayList<>();
		try {
			String sql = "select * from loan_account join customer on(loan_account.customer_id = customer.customer_id) where customer.branch_code=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, branch_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanAccount loanAccount = new LoanAccount();
				loanAccount.setLoan_account_number(rs.getString(1));
				loanAccount.setApproval_date(rs.getDate(6));
				loanAccount.setCustomer_id(rs.getString(2));
				loanAccount.setDisbursed_amount(rs.getFloat(5));
				loanAccount.setEmi(rs.getFloat(9));
				loanAccount.setLoan_application_number(rs.getString(8));
				loanAccount.setLoan_status(rs.getInt(10));
				loanAccount.setLoan_tenure(rs.getInt(11));
				loanAccount.setLoan_type_code(rs.getInt(4));
				loanAccount.setManager_id(rs.getString(3));
				loanAccount.setRoi(rs.getFloat(12));
				loanAccount.setSanctioned_amount(rs.getFloat(7));

				result.add(loanAccount);
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

	@Override
	public LoanAccountBalance getLoanAccountDetails(String loan_account_number) {
		Connection con = dbConnection.connect();
		LoanAccountBalance result = new LoanAccountBalance();
		try {
			String sql = "select * from loan_account join loan_balance on (loan_account.loan_account_number = loan_balance.loan_account_number) where loan_account.loan_account_number =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setLoan_account_number(rs.getString(1));
				result.setApproval_date(rs.getDate(6));
				result.setCustomer_id(rs.getString(2));
				result.setDisbursed_amount(rs.getFloat(5));
				result.setEmi(rs.getFloat(9));
				result.setLoan_application_number(rs.getString(8));
				result.setLoan_status(rs.getInt(10));
				result.setLoan_tenure(rs.getInt(11));
				result.setLoan_type_code(rs.getInt(4));
				result.setManager_id(rs.getString(3));
				result.setRoi(rs.getFloat(12));
				result.setSanctioned_amount(rs.getFloat(7));
				result.setInterest_paid(rs.getFloat(14));
				result.setOutstanding_balance(rs.getFloat(15));
				result.setTenure_remaining(rs.getInt(16));
				result.setPriciple_paid(rs.getFloat(17));
				result.setOverdue(rs.getInt(18));

			}else {
				throw new ApplicationException("No account found");
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
