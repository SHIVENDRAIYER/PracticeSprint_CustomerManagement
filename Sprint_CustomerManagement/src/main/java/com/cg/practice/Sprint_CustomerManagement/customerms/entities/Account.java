package com.cg.practice.Sprint_CustomerManagement.customerms.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@GeneratedValue
	@Id
	
	private Long accountID;
	private Double balance;
	private LocalDateTime created;

	public Long getAccountID() {

		return accountID;
	}

	public void setAccountID(Long accountID) {

		this.accountID = accountID;
	}

	public Double getBalance() {

		return balance;
	}

	public void setBalance(Double balance) {

		this.balance = balance;
	}

	public LocalDateTime getCreated() {

		return created;
	}

	public void setCreated(LocalDateTime created) {

		this.created = created;
	}

	@Override
	public String toString() {
		
		return "Account [accountId=" + accountID + ", balance=" + balance + ", created=" + created + "]";
	}

	
	

}