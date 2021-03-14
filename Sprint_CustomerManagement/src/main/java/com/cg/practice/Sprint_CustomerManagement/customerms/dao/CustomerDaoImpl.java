/*package com.cg.practice.Sprint_CustomerManagement.customerms.dao;

import org.springframework.stereotype.Repository;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer add(Customer customer) {
		
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByID(Long customerID) {
		
		Customer customer = entityManager.find(Customer.class, customerID);
		if(customer ==null)
		{
			throw new CustomerNotFoundException("Customer does not exist");
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		
		customer = entityManager.merge(customer);
		return customer;
	}

}
*/