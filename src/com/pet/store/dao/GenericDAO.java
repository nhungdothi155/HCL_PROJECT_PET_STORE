package com.pet.store.dao;

import java.util.List;

public abstract class GenericDAO<T> {
	public abstract List<T> listAll();
	public abstract void insert(T t);
	public abstract void update(T t);
	public abstract void delete(int id);
	public abstract T getElementById(int id);

}
