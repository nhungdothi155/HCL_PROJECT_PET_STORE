package com.pet.store.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="seller")
public class Seller {
	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seller_id")
	private long sellerId;
	// username
	@Column(name="username")
	private String username;
	//password
	@Column(name="password")
	private String password;
	//time create
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="date_created")
//	private Date dateCreated;
//	//time modify
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="date_modified")
//	private Date dateModified;
	
	
	public Seller() {
		super();
	}
//	public Seller(long sellerId, String username, String password, Date dateCreated, Date dateModified) {
//		super();
//		this.sellerId = sellerId;
//		this.username = username;
//		this.password = password;
//		this.dateCreated = dateCreated;
//		this.dateModified = dateModified;
//	}
	public Seller( String username, String password) {
		super();
	
		this.username = username;
		this.password = password;
	
	}
	
	public Seller(long sellerId, String username, String password) {
		super();
		this.sellerId = sellerId;
		this.username = username;
		this.password = password;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Date getDateCreated() {
//		return dateCreated;
//	}
//	public void setDateCreated(Date dateCreated) {
//		this.dateCreated = dateCreated;
//	}
//	public Date getDateModified() {
//		return dateModified;
//	}
//	public void setDateModified(Date dateModified) {
//		this.dateModified = dateModified;
//	}
//	
	
	
}
