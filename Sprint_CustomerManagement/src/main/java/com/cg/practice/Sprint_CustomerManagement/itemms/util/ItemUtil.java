package com.cg.practice.Sprint_CustomerManagement.itemms.util;

import org.springframework.stereotype.Component;
import com.cg.practice.Sprint_CustomerManagement.itemms.dto.*;
import java.util.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;

@Component
public class ItemUtil {

	public ItemDetails toDetail(Item item) {
		ItemDetails itemDetails = new ItemDetails();

		itemDetails.setItemID(item.getItemID());
		itemDetails.setPrice(item.getPrice());
		itemDetails.setDescription(item.getDescription());

		if (itemDetails.getBoughtBy() != null) {

			itemDetails.setCustomerID(item.getBoughtBy().getCustID());
			itemDetails.setCustomerName(item.getBoughtBy().getCustName());
		}
		return itemDetails;
	}

	public Set<ItemDetails> toDetailSet(Set<Item> items) {

		Set<ItemDetails> itemDesired = new HashSet<>();

		for (Item item : items) {
			ItemDetails itemDetails = toDetail(item);
			itemDesired.add(itemDetails);
		}
		return itemDesired;
	}

}
