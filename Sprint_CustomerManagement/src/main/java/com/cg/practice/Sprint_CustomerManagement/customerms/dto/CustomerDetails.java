package com.cg.practice.Sprint_CustomerManagement.customerms.dto;

public class CustomerDetails {

	private long custID;
	private String custName;
	private long accountID;
	private double balance;

	public CustomerDetails() {

	}

	public long getCustID() {

		return custID;
	}

	public void setCustID(long custID) {

		this.custID = custID;
	}

	public String getCustName() {

		return custName;
	}

	public void setCustName(String custName) {

		this.custName = custName;
	}

	public long getAccountID() {

		return accountID;
	}

	public void setAccountID(long accountID) {

		this.accountID = accountID;
	}

	public double getBalance() {

		return balance;
	}

	public void setBalance(double balance) {

		this.balance = balance;
	}

}
