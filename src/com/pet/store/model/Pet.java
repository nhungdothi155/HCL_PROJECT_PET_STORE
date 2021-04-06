package com.pet.store.model;

import java.util.Date;


public class Pet {
	enum Status{
		in_stock, out_of_stock
	};
	private long pet_id;
	private long seller_id;
	private String pet_name;
	private int pet_age;
	private double pet_weight;
	private String pet_type;
	private String pet_origin;
	private Status status;
	private String cover_photo;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private String pet_description;
	private Date date_created;
	private Date date_modified;
	public Pet(long pet_id, long seller_id, String pet_name, int pet_age, double pet_weight, String pet_type,
			String pet_origin, Status status, String cover_photo, String photo1, String photo2, String photo3,
			String photo4, String pet_description, Date date_created, Date date_modified) {
		super();
		this.pet_id = pet_id;
		this.seller_id = seller_id;
		this.pet_name = pet_name;
		this.pet_age = pet_age;
		this.pet_weight = pet_weight;
		this.pet_type = pet_type;
		this.pet_origin = pet_origin;
		this.status = status;
		this.cover_photo = cover_photo;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.pet_description = pet_description;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Pet(long seller_id, String pet_name, int pet_age, double pet_weight, String pet_type, String pet_origin,
			Status status, String cover_photo, String photo1, String photo2, String photo3, String photo4,
			String pet_description, Date date_created, Date date_modified) {
		super();
		this.seller_id = seller_id;
		this.pet_name = pet_name;
		this.pet_age = pet_age;
		this.pet_weight = pet_weight;
		this.pet_type = pet_type;
		this.pet_origin = pet_origin;
		this.status = status;
		this.cover_photo = cover_photo;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.pet_description = pet_description;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Pet() {
		super();
	}
	public long getPet_id() {
		return pet_id;
	}
	public long getSeller_id() {
		return seller_id;
	}
	public String getPet_name() {
		return pet_name;
	}
	public int getPet_age() {
		return pet_age;
	}
	public double getPet_weight() {
		return pet_weight;
	}
	public String getPet_type() {
		return pet_type;
	}
	public String getPet_origin() {
		return pet_origin;
	}
	public Status getStatus() {
		return status;
	}
	public String getCover_photo() {
		return cover_photo;
	}
	public String getPhoto1() {
		return photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public String getPhoto4() {
		return photo4;
	}
	public String getPet_description() {
		return pet_description;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setPet_id(long pet_id) {
		this.pet_id = pet_id;
	}
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public void setPet_age(int pet_age) {
		this.pet_age = pet_age;
	}
	public void setPet_weight(double pet_weight) {
		this.pet_weight = pet_weight;
	}
	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}
	public void setPet_origin(String pet_origin) {
		this.pet_origin = pet_origin;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setCover_photo(String cover_photo) {
		this.cover_photo = cover_photo;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	public void setPet_description(String pet_description) {
		this.pet_description = pet_description;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
