package com.metacube.ead.facade;

import java.util.List;

import com.metacube.ead.dao.ProductDao;
import com.metacube.ead.enums.DBTYPE;
import com.metacube.ead.enums.Status;
import com.metacube.ead.factory.FactoryPattern;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Class Facade {FACADE LAYER}.
 * @author Aman Gautam
 */
public class Facade {
	
	ProductDao objProductDao = FactoryPattern.getProductDao(DBTYPE.MYSQL);
	
	/**
	 * Checks login status.
	 *
	 * @param id 
	 * @param pass
	 * @return true, if successful
	 */
	public boolean checkLoginStatus(int id, String pass) {
		return objProductDao.checkLoginStatus(id,pass);
	}

	/**
	 * Show cart.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<ShoppingCart> showCart(int id) {
		return objProductDao.showCart(id);
	}

	/**
	 * Show product in the cart.
	 *
	 * @return the list
	 */
	public List<Product> showProduct() {
		return objProductDao.showProduct();
	}

	/**
	 * Update cart.
	 *
	 * @param id the id
	 * @param productId the product id
	 * @param qty the qty
	 * @return enum status
	 */
	public Status updateCart(int id,int productId, int qty) {
		return objProductDao.updateCart(id,productId, qty);
	}

	/**
	 * Add the product to cart.
	 *
	 * @param id 
	 * @param pId 
	 * @param pQty 
	 * @return  status
	 */
	public Status addProductToCart(int id,int pId, int pQty) {
		return objProductDao.addToProductToCart(id,pId,pQty);
	}
}
