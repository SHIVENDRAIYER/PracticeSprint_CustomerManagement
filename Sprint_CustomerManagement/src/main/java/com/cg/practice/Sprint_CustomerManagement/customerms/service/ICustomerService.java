package com.cg.practice.Sprint_CustomerManagement.customerms.service;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;

public interface ICustomerService {

	Customer findByID(Long customerID);

	Customer createCustomer(String name);

	Customer addAmount(Long customerId, double amount);
}
