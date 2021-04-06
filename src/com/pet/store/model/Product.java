package com.pet.store.model;

import java.util.Date;

public class Product {
	enum State{
		NEW, USED
	}
	private long product_id;
	private long seller_id;
	private long category_id;
	private String product_name;
	private String description;
	private String brand;
	private String materia;
	private String origin;
	private double price;
	private long product_number;
	private String cover_photo;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private State product_state;
	private Date date_created;
	private Date date_modified;
	public Product(long product_id, long seller_id, long category_id, String product_name, String description,
			String brand, String materia, String origin, double price, long product_number, String cover_photo,
			String photo1, String photo2, String photo3, String photo4, State product_state, Date date_created,
			Date date_modified) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.description = description;
		this.brand = brand;
		this.materia = materia;
		this.origin = origin;
		this.price = price;
		this.product_number = product_number;
		this.cover_photo = cover_photo;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.product_state = product_state;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Product(long seller_id, long category_id, String product_name, String description, String brand,
			String materia, String origin, double price, long product_number, String cover_photo, String photo1,
			String photo2, String photo3, String photo4, State product_state, Date date_created, Date date_modified) {
		super();
		this.seller_id = seller_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.description = description;
		this.brand = brand;
		this.materia = materia;
		this.origin = origin;
		this.price = price;
		this.product_number = product_number;
		this.cover_photo = cover_photo;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.product_state = product_state;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Product() {
		super();
	}
	public long getProduct_id() {
		return product_id;
	}
	public long getSeller_id() {
		return seller_id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getDescription() {
		return description;
	}
	public String getBrand() {
		return brand;
	}
	public String getMateria() {
		return materia;
	}
	public String getOrigin() {
		return origin;
	}
	public double getPrice() {
		return price;
	}
	public long getProduct_number() {
		return product_number;
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
	public State getProduct_state() {
		return product_state;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setProduct_number(long product_number) {
		this.product_number = product_number;
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
	public void setProduct_state(State product_state) {
		this.product_state = product_state;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
