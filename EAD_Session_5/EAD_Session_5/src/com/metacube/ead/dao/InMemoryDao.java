package com.metacube.ead.dao;

import java.util.List;

import com.metacube.ead.enums.Status;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Class InMemoryDao.{DAO LAYER}
 * @author Aman Gautam
 */
public class InMemoryDao implements BaseDao<Product>{

	/*
	 * Definition of showProduct method 
	 */
	@Override
	public List<Product> showProduct() {
		return null;
	}

	/*
	 * Definition of checkLoginStatus method 
	 */
	@Override
	public boolean checkLoginStatus(int id, String pass) {
		return false;
	}
	
	/*
	 * Definition of showCart method 
	 */
	@Override
	public List<ShoppingCart> showCart(int id) {
		return null;
	}

	/*
	 * Definition of addToProductToCart method 
	 */
	@Override
	public Status addToProductToCart(int id ,int pId, int pQty) {
		return null;
	}

	/*
	 * Definition of updateCart method
	 */
	@Override
	public Status updateCart(int id, int productId, int qty) {
		return null;
	}

}
