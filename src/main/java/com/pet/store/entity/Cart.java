package com.pet.store.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "cart")
public class Cart {
	//id , cartid, customer_id,datemodifed, datecread 
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable=false)
	private Customer customer;
	
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	
	public Cart() {
		super();
	}
	public Cart( Customer customer) {
		super();
		this.customer = customer;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
