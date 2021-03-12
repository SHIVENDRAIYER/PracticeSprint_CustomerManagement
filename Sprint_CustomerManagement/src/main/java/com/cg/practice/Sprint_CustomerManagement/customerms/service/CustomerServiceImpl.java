package com.cg.practice.Sprint_CustomerManagement.customerms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.dao.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public Customer findByID(Long customerID) {

		validateId(customerID);
		Customer customer = dao.findByID(customerID);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {

		Customer customer = new Customer();
		customer.setCustName(name);
		customer = dao.add(customer);
		return customer;
	}

	public void validateId(Long id) {

		if (id < 0) {

			throw new InvalidIDException("id should not be negative");
		}
	}

	void validateName(String name) {

		if (name == null || name.isEmpty() || name.trim().isEmpty()) {

			throw new InvalidNameException("name can't be null or empty");
		}
	}

}
