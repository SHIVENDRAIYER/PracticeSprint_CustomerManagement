package com.cg.practice.Sprint_CustomerManagement.customerms.service;

import javax.transaction.Transactional;
import java.util.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.dao.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private ICustomerDao dao;

	@Transactional
	@Override
	public Customer createCustomer(String name) {

		LocalDateTime localDateTime = LocalDateTime.now();
		Customer customer = new Customer();
		Account account = new Account(0.0, localDateTime);
		customer.setAccount(account);
		customer.setCustName(name);
		entityManager.persist(account);
		customer = dao.add(customer);
		return customer;
	}

	@Override
	public Customer findByID(Long customerID) {

		validateId(customerID);
		Customer customer = dao.findByID(customerID);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerID, double amount) {

		Customer customer = dao.findByID(customerID);
		customer.getAccount().setBalance(amount);
		customer = dao.update(customer);
		return customer;
	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID) {

		validateId(customerID);
		Customer customer = findByID(customerID);
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;
	}

	public void validateId(Long id) {

		if (id < 0) {

			throw new InvalidIdException("id should not be negative");
		}
	}

	void validateName(String name) {

		if (name == null || name.isEmpty() || name.trim().isEmpty()) {

			throw new InvalidNameException("name can't be null or empty");
		}
	}

}
