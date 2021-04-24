package com.pet.store.entity;

import java.io.Serializable;
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
@Table(name = "\"cart\"")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id , cartid, customer_id,datemodifed, datecread 
	@Id
	@Column(name="cart_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable=false,unique = true)
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
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	

}
