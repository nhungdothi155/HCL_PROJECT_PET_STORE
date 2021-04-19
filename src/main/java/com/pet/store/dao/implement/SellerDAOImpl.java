package com.pet.store.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.SellerDAO;
import com.pet.store.entity.Seller;

public class SellerDAOImpl extends GenericDAO<Seller> implements SellerDAO {
	
	@Override
	public boolean isLogin(String username, String password) {
//		Connection con = connection();
//		PreparedStatement statement;
//		try {
//			statement = con.prepareStatement("select * from seler where username =? and password=?");
//			statement.setString(1, username);
//			statement.setString(2, password);
//			ResultSet rs = statement.executeQuery();
//			while(rs.next()) {
//				return true;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		// TODO Auto-generated method stub
//		return false;
		return false;
	}

	@Override
	public List<Seller> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Seller t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller getElementById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
