package com.metacube.ead.controller;

import java.util.List;
import com.metacube.ead.enums.Status;
import com.metacube.ead.facade.Facade;
import com.metacube.ead.factory.FactoryPattern;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Class Controller which Passes the manages input and output between facade and view Layer.
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class Controller {

	Facade objFacade = (Facade) FactoryPattern.FactoryPatternObject("Facade");
	
	/**
	 * Check login status.
	 *
	 * @param id
	 * @param pass 
	 * @return true, if successful
	 */
	public boolean checkLoginStatus(int id, String pass) {
		return objFacade.checkLoginStatus(id,pass);
	}

	/**
	 * Show cart.
	 *
	 * @param id
	 * @return list
	 */
	public List<ShoppingCart> showCart(int id) {
		return objFacade.showCart(id);
	}
	
	/**
	 * Show product in the cart of the logged in user.
	 *
	 * @return the list
	 */
	public List<Product> showProduct() {
		return objFacade.showProduct();
	}

	/**
	 * Update cart in the database.
	 *
	 * @param userID 
	 * @param productId
	 * @param qty 
	 * @return status
	 */
	public Status updateCart(int userID,int productId,int qty) {
		return objFacade.updateCart(userID,productId,qty);
	}

	/**
	 * Adds the to product to cart.
	 *
	 * @param id 
	 * @param pId
	 * @param pQty 
	 * @return status
	 */
	public Status addToProductToCart(int id,int pId, int pQty) {
		return objFacade.addProductToCart(id,pId,pQty);
	}

	

}
