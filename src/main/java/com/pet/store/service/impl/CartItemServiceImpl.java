package com.pet.store.service.impl;

import com.pet.store.dao.implement.CartItemDAOImpl;
import com.pet.store.entity.CartItem;
import com.pet.store.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	private CartItemDAOImpl cartItemDao;

	public CartItemServiceImpl() {
		// TODO Auto-generated constructor stub
		cartItemDao = new CartItemDAOImpl();
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		cartItemDao.update(cartItem);

	}

	@Override
	public void deleteCartItem(long id) {
		cartItemDao.delete(id);
		
	}

	@Override
	public CartItem getCartItemById(long id) {
		return cartItemDao.getElementById(id);
		
	}

}
