package com.pet.store.model;

import java.util.Date;

public class Seller {
	private long seller_id;
	private String username;
	private String password;
	private Date date_created;
	private Date date_modified;
	public Seller(long seller_id, String username, String password, Date date_created, Date date_modified) {
		super();
		this.seller_id = seller_id;
		this.username = username;
		this.password = password;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Seller(String username, String password, Date date_created, Date date_modified) {
		super();
		this.username = username;
		this.password = password;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public long getSeller_id() {
		return seller_id;
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
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
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
