package com.nongming.sunshine.entity;

public class Amount {
	private int userId;//用户Id
	private int balance;//余额（单位分）
	private int regularAmount;//定期金额（单位分）
	private int regularInterest;//定期利息(单位分）
	private int currentAmount;//活期金额
	private int currentInterest;//活期利息(单位分）
	private int loan;//借款金额（单位分）
	private int loanInterest;//借款利息
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getRegularAmount() {
		return regularAmount;
	}
	public void setRegularAmount(int regularAmount) {
		this.regularAmount = regularAmount;
	}
	public int getRegularInterest() {
		return regularInterest;
	}
	public void setRegularInterest(int regularInterest) {
		this.regularInterest = regularInterest;
	}
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public int getCurrentInterest() {
		return currentInterest;
	}
	public void setCurrentInterest(int currentInterest) {
		this.currentInterest = currentInterest;
	}
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
		this.loan = loan;
	}
	public int getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(int loanInterest) {
		this.loanInterest = loanInterest;
	}
	
}
