package com.project.dao;

import com.project.model.Cart;
import com.project.model.CartItem;
import com.project.model.User;

public interface CartDao {

	public Cart getCartByUser(User user);
	public void addCartItem(Cart cart);
	public void removeCartItem(Cart cart,CartItem cartItem);
	public void deleteCart(Cart cart);
	public CartItem getCartItemById(int id);
}
