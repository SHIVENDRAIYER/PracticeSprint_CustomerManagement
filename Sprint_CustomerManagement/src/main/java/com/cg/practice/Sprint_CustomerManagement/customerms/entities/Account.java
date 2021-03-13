package com.cg.practice.Sprint_CustomerManagement.customerms.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Account {

	@GeneratedValue
	@Id

	private Long accountID;
	private Double balance;
	private LocalDateTime created;

	public Account() {

	}

	public Account(Double balance, LocalDateTime created) {

		this.balance = balance;
		this.created = created;
	}

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

	@Override
	public int hashCode() {

		return Objects.hash(accountID);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Account account = (Account) o;
		return Objects.equals(accountID, account.accountID);
	}

}