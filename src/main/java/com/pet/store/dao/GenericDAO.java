package com.pet.store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.pet.store.DBConnection.DBConnection;

public abstract class GenericDAO<T> {
	public abstract List<T> listAll();
	public abstract void insert(T t);
	public abstract void update(T t);
	public abstract void delete(int id);
	public abstract T getElementById(long id);
//	public Connection connection() {
//		DataSource ds = DBConnection.getMySQLDataSource();
//		Connection con = null;
//		try {
//			 con = ds.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//		
//	}
	

}
