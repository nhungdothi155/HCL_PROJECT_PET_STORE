package com.pet.store.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="\"order\"")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	// customer id
	@ManyToOne
	@JoinColumn(name="customer_id",nullable=false)
	private Customer customer;
	// total price of order
	@Column(name="total_price")
	private double totalPrice;
	// firstname
	@Column(name="customer_firstname")
	private String customerFirstname;
	//lastname
	@Column(name="customer_lastname")
	private String customerLastname;
	//country
	@Column(name="customer_country")
	private String customerCountry;
	//city
	@Column(name="customer_city")
	private String customerCity;
	//address
	@Column(name="customer_address")
	private String customerAddress;
	//phone
	@Column(name="customer_phone")
	private String customerPhone;
	//email
	@Column(name="customer_email")
	private String customerEmail;
	//zipcode
	@Column(name="zip_code")
	private String zipCode;
	// note of order
	@Column(name="note")
	private String note;
	
	@OneToMany(mappedBy="order")
	private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
	
	
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	public Order() {
		super();
	}
	
	public Order(long orderId, Customer customer, double totalPrice, String customerFirstname, String customerLastname,
			String customerCountry, String customerCity, String customerAddress, String customerPhone,
			String customerEmail, String zipCode, String note, List<OrderProduct> orderProducts) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.customerCountry = customerCountry;
		this.customerCity = customerCity;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.zipCode = zipCode;
		this.note = note;
		this.orderProducts = orderProducts;
	}
	public Order(long orderId, Customer customer, double totalPrice, String customerFirstname, String customerLastname,
			String customerCountry, String customerCity, String customerAddress, String customerPhone,
			String customerEmail, String zipCode, String note) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.customerCountry = customerCountry;
		this.customerCity = customerCity;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.zipCode = zipCode;
		this.note = note;
	}
	public Order(Customer customer, double totalPrice, String customerFirstname, String customerLastname,
			String customerCountry, String customerCity, String customerAddress, String customerPhone,
			String customerEmail, String zipCode, String note) {
		super();
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.customerCountry = customerCountry;
		this.customerCity = customerCity;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.zipCode = zipCode;
		this.note = note;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCustomerFirstname() {
		return customerFirstname;
	}
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}
	public String getCustomerLastname() {
		return customerLastname;
	}
	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
