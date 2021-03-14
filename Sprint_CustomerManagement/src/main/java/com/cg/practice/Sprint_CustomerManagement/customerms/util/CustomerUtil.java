package com.cg.practice.Sprint_CustomerManagement.customerms.util;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.practice.Sprint_CustomerManagement.customerms.dto.*;

@Component
public class CustomerUtil {

	public CustomerDetails toDetail(Customer customer) {

		CustomerDetails custDetails = new CustomerDetails();

		custDetails.setCustID(customer.getCustID());
		custDetails.setCustName(customer.getCustName());
		custDetails.setAccountID(customer.getAccount().getAccountID());
		custDetails.setBalance(customer.getAccount().getBalance());

		return custDetails;
	}

	public List<CustomerDetails> toDetailsList(Collection<Customer> customers) {

		List<CustomerDetails> custDesired = new ArrayList<>();

		for (Customer customer : customers) {

			CustomerDetails custDetails = toDetail(customer);
			custDesired.add(custDetails);
		}

		return custDesired;

	}

}
