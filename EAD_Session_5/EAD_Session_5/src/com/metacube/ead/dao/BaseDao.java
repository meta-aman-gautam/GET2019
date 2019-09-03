package com.metacube.ead.dao;

import java.util.List;
import com.metacube.ead.enums.Status;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Interface BaseDao.{DAO Layer}
 * @author Aman Gautam
 *
 * @param <T> the generic type
 */
public interface BaseDao <T extends Product>{

	/**
	 * Adds the to product to cart.
	 *
	 * @param id 
	 * @param pId
	 * @param pQty 
	 * @return {enum} status
	 */
	public Status addToProductToCart(int id ,int pId, int pQty);
	
	/**
	 * Updates cart.
	 *
	 * @param id 
	 * @param productId d
	 * @param qty
	 * @return  status{enum}
	 */
	public Status updateCart(int id,int productId ,int qty);
	
	/**
	 * Show cart.
	 *
	 * @param id 
	 * @return list{ShoppingCart}
	 */
	public List<ShoppingCart>showCart(int id);
	
	/**
	 * Show product in the cart.
	 *
	 * @return the list{Product}
	 */
	public List<Product>showProduct();
	
	/**
	 * Check login status.
	 *
	 * @param id 
	 * @param pass
	 * @return true, if successful
	 */
	public boolean checkLoginStatus(int id, String pass);

}
