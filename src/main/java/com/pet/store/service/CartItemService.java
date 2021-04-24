package com.pet.store.service;

import com.pet.store.entity.CartItem;

public interface CartItemService {
	public void updateCartItem(CartItem cartItem);
	public void deleteCartItem(long id);
	public CartItem getCartItemById(long id);
	

}
