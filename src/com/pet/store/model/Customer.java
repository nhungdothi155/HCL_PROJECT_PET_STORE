package com.pet.store.model;

import java.util.Date;

public class Customer {
	private long id;
	private String firstname;
	private Date dob;
	private String address;
	private String phone;
	private String username;
	private String password;
	private Date date_created;
	private Date date_modified;
	public Customer(long id, String firstname, Date dob, String address, String phone, String username, String password,
			Date date_created, Date date_modified) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Customer(String firstname, Date dob, String address, String phone, String username, String password,
			Date date_created, Date date_modified) {
		super();
		this.firstname = firstname;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Customer() {
		super();
	}
	public long getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public Date getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
