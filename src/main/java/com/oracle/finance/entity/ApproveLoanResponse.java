package com.oracle.finance.entity;

public class ApproveLoanResponse {
private int approvalCode;
private LoanAccount loanAccount;


public ApproveLoanResponse() {
	super();
}
public ApproveLoanResponse(int approvalCode, LoanAccount loanAccount) {
	super();
	this.approvalCode = approvalCode;
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


}
