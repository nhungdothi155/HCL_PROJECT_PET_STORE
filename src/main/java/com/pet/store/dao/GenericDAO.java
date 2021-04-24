package com.pet.store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.pet.store.DBConnection.DBConnection;

public abstract class GenericDAO<T> {
	public abstract List<T> listAll();
	public abstract int insert(T t);
	public abstract int update(T t);
	public abstract void delete(long id);
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
