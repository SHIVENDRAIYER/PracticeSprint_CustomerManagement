package com.cg.practice.Sprint_CustomerManagement.customerms.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.*;

@Entity
public class Customer {

	@GeneratedValue
	@Id
	private Long custID;
	private String custName;

	@OneToOne
	private Account account;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Item> boughtItems;

	public Customer() {

	}

	public Customer(String custName, Account account) {

		this.custName = custName;
		this.account = account;
	}

	public Long getCustID() {

		return custID;
	}

	public void setCustID(Long custID) {

		this.custID = custID;
	}

	public String getCustName() {

		return custName;
	}

	public void setCustName(String custName) {

		this.custName = custName;
	}

	public Account getAccount() {

		return account;
	}

	public void setAccount(Account account) {

		this.account = account;
	}

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custID + ", custName=" + custName + ", account=" + account + ", boughtItems="
				+ boughtItems + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(custID, customer.custID);
	}

	@Override
	public int hashCode() {

		return Objects.hash(custID);
	}
}