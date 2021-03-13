package com.cg.practice.Sprint_CustomerManagement.customerms.service;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import java.util.*;

public interface ICustomerService {

	Customer findByID(Long customerID);

	Customer createCustomer(String name);

	Customer addAmount(Long customerID, double amount);
	
	Set<Item> itemsBoughtByCustomer(Long customerID);
}
