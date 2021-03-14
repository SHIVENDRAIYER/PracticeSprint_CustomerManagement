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
//import javax.persistence.EntityManager;

@Service
public class CustomerServiceImpl implements ICustomerService {

	/*@Autowired
	private EntityManager entityManager;*/
	@Autowired
	private ICustomerRepository customerRepository;
	// private ICustomerDao customerDao;

	@Autowired
	private IAccountRepository accountRepository;

	@Transactional
	@Override
	public Customer createCustomer(String name) {

		/* LocalDateTime localDateTime = LocalDateTime.now(); 
		 * Customer customer = new Customer(); 
		 * Account account = new Account(0.0, localDateTime);
		 * customer.setAccount(account); 
		 * customer.setCustName(name);
		 * entityManager.persist(account); 
		 * customer = customerDao.add(customer); 
		 * return customer;
		 */

		LocalDateTime localDateTime = LocalDateTime.now();
		Account account = new Account(0.0, localDateTime);
		accountRepository.save(account);
		Customer customer = new Customer(name, account);
		customer = customerRepository.save(customer);
		return customer;

	}

	@Override
	public Customer findByID(Long customerID) {

		/* validateId(customerID); 
		 * Customer customer = customerDao.findByID(customerID);
		 * return customer;
		 */

		Optional<Customer> optional = customerRepository.findById(customerID);
		if (!optional.isPresent()) {

			throw new CustomerNotFoundException("customer not found for customerID=" + customerID);
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerID, double amount) {

		/* Customer customer = customerDao.findByID(customerID);
		 * customer.getAccount().setBalance(amount); 
		 * customer = customer.update(customer); 
		 * return customer;
		 */

		Customer customer = findByID(customerID);
		Account account = customer.getAccount();
		account.setBalance(amount);
		accountRepository.save(account);
		customerRepository.save(customer);
		return customer;

	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID) {

		/* validateId(customerID); 
		 * Customer customer = findByID(customerID);
		 * Set<Item>itemSet = customer.getBoughtItems(); 
		 * return itemSet;
		 */

		Optional<Customer> customer = customerRepository.findById(customerID);
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer not available for given id ");
		}
		Customer cust = customer.get();
		Set<Item> itemSet = cust.getBoughtItems();
		return itemSet;
	}

	public void validateId(Long id) {

		if (id < 0) {

			throw new InvalidCustomerIdException("id should not be negative");
		}
	}

	void validateName(String name) {

		if (name == null || name.isEmpty() || name.trim().isEmpty()) {

			throw new InvalidCustomerNameException("name can't be null or empty");
		}
	}

}
