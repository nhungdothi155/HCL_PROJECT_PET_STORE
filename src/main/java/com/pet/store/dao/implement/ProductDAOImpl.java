package com.pet.store.dao.implement;
import java.util.List;

import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.ProductDAO;
import com.pet.store.entity.Product;
public class ProductDAOImpl extends GenericDAO<Product> implements ProductDAO {

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Product t) {
		return -1;
		// TODO Auto-generated method stub
		
	}

	@Override
	public  int update(Product t) {
		return -1;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getElementById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
