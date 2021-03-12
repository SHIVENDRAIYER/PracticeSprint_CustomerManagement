package com.cg.practice.Sprint_CustomerManagement.customerms.dao;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;

public interface ICustomerDao {

	Customer add(Customer customer);

	Customer findByID(Long customerID);

	Customer update(Customer customer);
}
