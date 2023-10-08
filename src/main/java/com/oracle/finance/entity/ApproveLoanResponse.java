package com.oracle.finance.entity;

public class ApproveLoanResponse {
private int approvalCode;
private String email,customername,loanaplicationnumber;
private LoanAccount loanAccount;


public ApproveLoanResponse() {
	super();
}


public ApproveLoanResponse(int approvalCode, String email, String customername, String loanaplicationnumber,
		LoanAccount loanAccount) {
	super();
	this.approvalCode = approvalCode;
	this.email = email;
	this.customername = customername;
	this.loanaplicationnumber = loanaplicationnumber;
	this.loanAccount = loanAccount;
}


public int getApprovalCode() {
	return approvalCode;
}
public void setApprovalCode(int approvalCode) {
	this.approvalCode = approvalCode;
}
public LoanAccount getLoanAccount() {
	return loanAccount;
}
public void setLoanAccount(LoanAccount loanAccount) {
	this.loanAccount = loanAccount;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}


public String getLoanaplicationnumber() {
	return loanaplicationnumber;
}


public void setLoanaplicationnumber(String loanaplicationnumber) {
	this.loanaplicationnumber = loanaplicationnumber;
}


}
