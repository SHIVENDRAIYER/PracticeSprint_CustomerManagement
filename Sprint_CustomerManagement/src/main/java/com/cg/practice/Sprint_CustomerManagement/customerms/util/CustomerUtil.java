package com.cg.practice.Sprint_CustomerManagement.customerms.util;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.practice.Sprint_CustomerManagement.customerms.dto.*;

@Component
public class CustomerUtil {

	public CustomerDetails toDetail(Customer customer) {

		CustomerDetails details = new CustomerDetails();

		details.setCustID(customer.getCustID());
		details.setCustName(customer.getCustName());
		details.setAccountID(customer.getAccount().getAccountID());
		details.setBalance(customer.getAccount().getBalance());

		return details;
	}

	public List<CustomerDetails> toDetailsList(Collection<Customer> customers) {

		List<CustomerDetails> desired = new ArrayList<>();

		for (Customer customer : customers) {

			CustomerDetails details = toDetail(customer);
			desired.add(details);
		}

		return desired;

	}

}
