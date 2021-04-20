package com.pet.store.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {
	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pet_id")
	private long petId;
	//seller
//	@ManyToOne
//	@JoinColumn(name="seller_id")
//	private Seller seller;
	
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
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	//photos of pet
	@Column(name="photos")
	private String photos;
	
	//description of pet
	@Column(name="pet_description")
	private String description;
	

	public Pet(long petId, String petName, float petAge, double petWeight, String petType, String petOrigin,
			Status status, String photos, String description) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petWeight = petWeight;
		this.petType = petType;
		this.petOrigin = petOrigin;
		this.status = status;
		this.photos = photos;
		this.description = description;
	}


	public Pet( String petName, float petAge, double petWeight, String petType, String petOrigin,
			Status status, String photos, String description) {
		super();
		
		this.petName = petName;
		this.petAge = petAge;
		this.petWeight = petWeight;
		this.petType = petType;
		this.petOrigin = petOrigin;
		this.status = status;
		this.photos = photos;
		this.description = description;
	}

	
	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public float getPetAge() {
		return petAge;
	}

	public void setPetAge(float petAge) {
		this.petAge = petAge;
	}

	public double getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(double petWeight) {
		this.petWeight = petWeight;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetOrigin() {
		return petOrigin;
	}

	public void setPetOrigin(String petOrigin) {
		this.petOrigin = petOrigin;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
