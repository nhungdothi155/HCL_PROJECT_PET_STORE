package com.pet.store.entity;

import java.util.Date;

public class Cart {
	private long  cart_id;
	private long customer_id;
	private Date date_created;
	private Date date_modified;
	public Cart(long cart_id, long customer_id, Date date_created, Date date_modified) {
		super();
		this.cart_id = cart_id;
		this.customer_id = customer_id;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Cart(long customer_id, Date date_created, Date date_modified) {
		super();
		this.customer_id = customer_id;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Cart() {
		super();
	}
	public long getCart_id() {
		return cart_id;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
