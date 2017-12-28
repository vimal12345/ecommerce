package com.project.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CartDao;
import com.project.model.Cart;
import com.project.model.CartItem;
import com.project.model.User;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCartItem(Cart cart) {

		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	@Override
	public void removeCartItem(Cart cart, CartItem cartItem) {
		int count = 0;
		for(CartItem car : cart.getCartItems()){
			if (car.getId() == cartItem.getId()) {
				System.out.println("----------------------------------------------------- found");
			}else{
				count++;
			}
		}
		List<CartItem> cis = cart.getCartItems();
		
		cart.setGrandTotal(cart.getGrandTotal() - cartItem.getSubTotal());
		cis.remove(count);
		cart.setCartItems(cis);
		addCartItem(cart);

	}

	@Override
	public void deleteCart(Cart cart) {
		
		sessionFactory.getCurrentSession().delete(cart);

	}

	@Override
	public Cart getCartByUser(User user) {
		
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM Cart WHERE USER_ID = '"+user.getId()+"'", Cart.class).getSingleResult();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public CartItem getCartItemById(int id) {
		
		return sessionFactory.getCurrentSession().get(CartItem.class, id);
	}

}
