package com.pet.store.dao;

import java.sql.Connection;

import com.pet.store.entity.Seller;

public interface SellerDAO {
	public Seller isLogin(String username,String password);

}
