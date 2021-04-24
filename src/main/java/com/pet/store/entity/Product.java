package com.pet.store.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//id	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="product_id",updatable = false, nullable = false)
private long productId;
//category
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="category_id",updatable = false, nullable = false)
private Category category;
//name of product
@Column(name="product_name")
private String productName;
// the description of product
@Column(name="description")
private String description;
// the brand of product
@Column(name="brand")
private String brand;
// the material of product
@Column(name="material")
private String material;
// the origin of product
@Column(name="origin")
private String origin;
@Column(name="price")
private float price;
// the numbers of product are available
@Column(name="product_numbers")
private int productNumbers;
//the photos of product
@Column(name="photos")
private String photos;
// the state of product : new or used
@Enumerated(EnumType.STRING)
@Column(name="product_state")
private State productState;

@OneToMany(mappedBy="product")
private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

@OneToMany(mappedBy="product")
private List<CartItem> cartItems = new ArrayList<CartItem>();


public Product() {
	super();
}

public Product(long productId, Category category, String productName, String description, String brand, String material,
		String origin,float price, int productNumbers, String photos, State productState) {
	super();
	this.productId = productId;
	this.category = category;
	this.productName = productName;
	this.description = description;
	this.brand = brand;
	this.material = material;
	this.origin = origin;
	this.price = price;
	this.productNumbers = productNumbers;
	this.photos = photos;
	this.productState = productState;
}

public Product( Category category, String productName, String description, String brand, String material,
		String origin,float price, int productNumbers, String photos, State productState) {
	super();
	
	this.category = category;
	this.productName = productName;
	this.description = description;
	this.brand = brand;
	this.material = material;
	this.origin = origin;
	this.price= price;
	this.productNumbers = productNumbers;
	this.photos = photos;
	this.productState = productState;
}



public List<CartItem> getCartItems() {
	return cartItems;
}

public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}

public List<OrderProduct> getOrderProducts() {
	return orderProducts;
}

public void setOrderProducts(List<OrderProduct> orderProducts) {
	this.orderProducts = orderProducts;
}

public Category getCategory() {
	return category;
}


public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public void setCategory(Category category) {
	this.category = category;
}

public long getProductId() {
	return productId;
}
public void setProductId(long productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public int getProductNumbers() {
	return productNumbers;
}
public void setProductNumbers(int productNumbers) {
	this.productNumbers = productNumbers;
}
public String getPhotos() {
	return photos;
}
public void setPhotos(String photos) {
	this.photos = photos;
}
public State getProductState() {
	return productState;
}
public void setProductState(State productState) {
	this.productState = productState;
}







}

