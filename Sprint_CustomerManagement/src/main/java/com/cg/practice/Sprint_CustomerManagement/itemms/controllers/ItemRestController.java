package com.cg.practice.Sprint_CustomerManagement.itemms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.practice.Sprint_CustomerManagement.itemms.dto.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.service.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.util.*;

@RequestMapping("/items")
@RestController
public class ItemRestController {

	@Autowired
	private IItemService itemService;

	@Autowired
	private ItemUtil itemUtil;

	@PostMapping("/add")
	public ItemDetails addItem(@RequestBody CreateItemRequest request) {

		return itemUtil.toDetail(itemService.create(request.getPrice(), request.getDescription()));
	}

	@GetMapping("/findbyid/{id}")
	public ItemDetails findById(@PathVariable String id) {

		return itemUtil.toDetail(itemService.findByID(id));
	}

	@PutMapping("/customer/add")
	public ItemDetails buyItem(@RequestBody BuyItemRequest request) {

		return itemUtil.toDetail(itemService.buyItem(request.getItemID(), request.getCustID()));
	}

}
