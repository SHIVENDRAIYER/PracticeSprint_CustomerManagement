package com.cg.practice.Sprint_CustomerManagement.customerms.controllers;

import com.cg.practice.Sprint_CustomerManagement.customerms.util.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.practice.Sprint_CustomerManagement.customerms.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private CustomerUtil customerUtil;

	@PostMapping("/add")
	public CustomerDetails addNewCustomer(@RequestBody CreateCustomerRequest request) {

		return customerUtil.toDetail(customerService.createCustomer(request.getCustName()));
	}

	@GetMapping("/findbyid/{id}")
	public CustomerDetails findById(@PathVariable long id) {

		return customerUtil.toDetail(customerService.findByID(id));
	}

	@PutMapping("/account/amount")
	public CustomerDetails addAmount(@RequestBody AddAmountRequest request) {

		return customerUtil.toDetail(customerService.addAmount(request.getAccountID(), request.getAmount()));
	}

}
