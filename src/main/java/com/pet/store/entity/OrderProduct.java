package com.pet.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="order_product")
public class OrderProduct {
	//id
	@Id
	@Column(name="order_product_id")
	private long orderProductId;
	// product_id
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	// order_id
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	//order product number
	@Column(name="order_product_number")
	private int orderProductNumber;
	public OrderProduct(long orderProductId, Product product, Order order, int orderProductNumber) {
		super();
		this.orderProductId = orderProductId;
		this.product = product;
		this.order = order;
		this.orderProductNumber = orderProductNumber;
	}
	public OrderProduct(Product product, Order order, int orderProductNumber) {
		super();
		this.product = product;
		this.order = order;
		this.orderProductNumber = orderProductNumber;
	}
	public long getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(long orderProductId) {
		this.orderProductId = orderProductId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderProductNumber() {
		return orderProductNumber;
	}
	public void setOrderProductNumber(int orderProductNumber) {
		this.orderProductNumber = orderProductNumber;
	}
	
	
}
