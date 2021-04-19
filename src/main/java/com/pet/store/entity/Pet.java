package com.pet.store.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {
	//id
	@Id
	@GeneratedValue
	@Column(name="pet_id")
	private long petId;
	//seller
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Seller seller;
	
	//name of pet
	@Column(name="pet_name")
	private String petName;
	
	//age of pet
	@Column(name="pet_age")
	private float petAge;
	
	//weight of pet
	@Column(name="pet_weight")
	private double petWeight;
	
	//type of pet
	@Column(name="pet_type")
	private String petType;
	
	//origin of pet
	@Column(name="pet_origin")
	private String petOrigin;
	
	// status of pet
	@Column(name="status")
	private Status status;
	
	//photos of pet
	@Column(name="photos")
	private String photos;
	
	//description of pet
	@Column(name="pet_description")
	private String description;
	
	
	
	
}
// define status for pet : in stock or out of stock
enum Status{
	IN_STOCK, OUT_OF_STOCK
	
}
