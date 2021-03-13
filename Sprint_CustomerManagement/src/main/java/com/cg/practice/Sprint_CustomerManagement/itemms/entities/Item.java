package com.cg.practice.Sprint_CustomerManagement.itemms.entities;

import javax.persistence.Entity;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Item {

	@Id
	private String itemId;
	private Double price;
	private String description;
	private LocalDateTime addedDate;

	@ManyToOne
	private Customer boughtBy;

	public Item() {

	}

	public Item(Double price, String description) {

		this.price = price;
		this.description = description;
	}

	public String getItemId() {

		return itemId;
	}

	public void setId(String itemId) {

		this.itemId = itemId;
	}

	public Double getPrice() {

		return price;
	}

	public void setPrice(Double price) {

		this.price = price;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public LocalDateTime getAddedDate() {

		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {

		this.addedDate = addedDate;
	}

	public Customer getBoughtBy() {

		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {

		this.boughtBy = boughtBy;
	}

	@Override
	public String toString() {
		return "Item [id=" + itemId + ", price=" + price + ", description=" + description + ", addedDate=" + addedDate
				+ ", boughtBy=" + boughtBy + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}

	public int hashCode() {

		return Objects.hash(itemId);
	}

}
