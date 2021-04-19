package com.pet.store.entity;

import java.util.Date;

public class Category {
	private long category_id;
	private String category_name;
	private String sub_categories;
	private Date date_created;
	private Date date_modified;
	public Category() {
		super();
	}
	public Category(long category_id, String category_name, String sub_categories, Date date_created,
			Date date_modified) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.sub_categories = sub_categories;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public Category(String category_name, String sub_categories, Date date_created, Date date_modified) {
		super();
		this.category_name = category_name;
		this.sub_categories = sub_categories;
		this.date_created = date_created;
		this.date_modified = date_modified;
	}
	public long getCategory_id() {
		return category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public String getSub_categories() {
		return sub_categories;
	}
	public Date getDate_created() {
		return date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public void setSub_categories(String sub_categories) {
		this.sub_categories = sub_categories;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
}
