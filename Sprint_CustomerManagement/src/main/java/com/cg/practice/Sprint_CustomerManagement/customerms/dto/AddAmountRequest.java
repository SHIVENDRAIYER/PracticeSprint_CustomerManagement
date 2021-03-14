package com.cg.practice.Sprint_CustomerManagement.customerms.dto;

public class AddAmountRequest {

	private long accountID;
	private double amount;

	public AddAmountRequest() {

	}

	public long getAccountID() {

		return accountID;
	}

	public void setAccountID(long accountID) {

		this.accountID = accountID;
	}

	public double getAmount() {

		return amount;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

}
