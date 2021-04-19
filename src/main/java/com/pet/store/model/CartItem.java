package com.pet.store.model;

import java.util.Date;

public class CartItem {
	private long cart_item_id;
	private long cart_id;
	private long product_id;
	private int quantity;
	private Date date_created;
	private Date date_modified;
	public CartItem() {
		super();
	}
	public CartItem(long cart_item_id, long cart_id, long product_id, int quantity, Date date_created,
			Date date_modified) {
		super();
		this.cart_item_id = cart_item_id;
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public CartItem(long cart_id, long product_id, int quantity, Date date_created, Date date_modified) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public long getCart_item_id() {
		return cart_item_id;
	}
	public long getCart_id() {
		return cart_id;
	}
	public long getProduct_id() {
		return product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setCart_item_id(long cart_item_id) {
		this.cart_item_id = cart_item_id;
	}
	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
