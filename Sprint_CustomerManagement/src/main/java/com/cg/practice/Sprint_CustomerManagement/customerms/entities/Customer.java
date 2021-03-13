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
	private Long custId;
	private String custName;

	@OneToOne
	private Account account;

	@OneToMany(fetch=FetchType.EAGER)
	private Set<Item> boughtItems;

	public Customer() {

	}

	public Customer(String custName, Account account) {

		this.custName = custName;
		this.account = account;
	}

	public Long getCustId() {

		return custId;
	}

	public void setCustId(Long custId) {

		this.custId = custId;
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
		return "Customer [custId=" + custId + ", custName=" + custName + ", account=" + account + ", boughtItems="
				+ boughtItems + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(custId, customer.custId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(custId);
	}
}