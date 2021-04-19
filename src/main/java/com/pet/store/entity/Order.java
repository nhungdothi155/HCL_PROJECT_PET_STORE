package com.pet.store.entity;

import java.util.Date;

public class Order {
	private long order_id;
	private long customer_id;
	private double total_price;
	private String customer_firstname;
	private String customer_lastname;
	private String customer_country;
	private String customer_city;
	private String customer_address;
	private String customer_phone;
	private String customer_email;
	private String zip_code;
	private String note;
	private Date date_created;
	private Date date_modified;
	public Order(long order_id, long customer_id, double total_price, String customer_firstname,
			String customer_lastname, String customer_country, String customer_city, String customer_address,
			String customer_phone, String customer_email, String zip_code, String note, Date date_created,
			Date date_modified) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.total_price = total_price;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.customer_country = customer_country;
		this.customer_city = customer_city;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.zip_code = zip_code;
		this.note = note;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Order(long customer_id, double total_price, String customer_firstname, String customer_lastname,
			String customer_country, String customer_city, String customer_address, String customer_phone,
			String customer_email, String zip_code, String note, Date date_created, Date date_modified) {
		super();
		this.customer_id = customer_id;
		this.total_price = total_price;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.customer_country = customer_country;
		this.customer_city = customer_city;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.zip_code = zip_code;
		this.note = note;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Order() {
		super();
	}
	public long getOrder_id() {
		return order_id;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	public String getCustomer_country() {
		return customer_country;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public String getZip_code() {
		return zip_code;
	}
	public String getNote() {
		return note;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	public void setCustomer_country(String customer_country) {
		this.customer_country = customer_country;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
