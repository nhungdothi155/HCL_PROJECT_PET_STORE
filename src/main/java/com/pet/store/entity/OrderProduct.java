package com.pet.store.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id
	@Id
	@Column(name = "order_product_id")
	private long orderProductId;
	// product_id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	// order_id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	// order product number
	@Column(name = "order_product_number")
	private int orderProductNumber;
	// time create
	@CreationTimestamp
	@Column(name="date_created")
	private Date dateCreated;
	//time modify
	@UpdateTimestamp
	@Column(name="date_modified")
	private Date dateModified;

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

	public OrderProduct() {
		super();
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	

}
