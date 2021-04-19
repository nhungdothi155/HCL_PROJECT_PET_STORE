package com.pet.store.entity;

import java.util.Date;

public class OrderProduct {
	private long order_product_id;
	private long product_id;
	private long order_id;
	private int order_product_number;
	private Date date_created;
	private Date date_modified;
	public OrderProduct(long order_product_id, long product_id, long order_id, int order_product_number,
			Date date_created, Date date_modified) {
		super();
		this.order_product_id = order_product_id;
		this.product_id = product_id;
		this.order_id = order_id;
		this.order_product_number = order_product_number;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public OrderProduct(long product_id, long order_id, int order_product_number, Date date_created,
			Date date_modified) {
		super();
		this.product_id = product_id;
		this.order_id = order_id;
		this.order_product_number = order_product_number;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public OrderProduct() {
		super();
	}
	public long getOrder_product_id() {
		return order_product_id;
	}
	public long getProduct_id() {
		return product_id;
	}
	public long getOrder_id() {
		return order_id;
	}
	public int getOrder_product_number() {
		return order_product_number;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setOrder_product_id(long order_product_id) {
		this.order_product_id = order_product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public void setOrder_product_number(int order_product_number) {
		this.order_product_number = order_product_number;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
