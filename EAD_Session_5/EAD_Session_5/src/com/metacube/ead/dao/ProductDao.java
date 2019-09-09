package com.metacube.ead.dao;

import java.util.List;
import com.metacube.ead.enums.DBTYPE;
import com.metacube.ead.enums.Status;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Class ProductDao.{DAO LAYER}
 * @author Aman Gautam
 */
public class ProductDao implements BaseDao<Product> {
	
	BaseDao<Product> objBaseDao ;
	
	/**
	 * Instantiates a new product dao.
	 *
	 * @param dbType 
	 */
	public ProductDao(DBTYPE dbType) {
		if(dbType==DBTYPE.MYSQL){
			objBaseDao= new MySqlDao();
		}
		else{
			objBaseDao= new InMemoryDao();
		}
	}

	/*
	 * Definition of updateCart method 
	 */
	@Override
	public Status updateCart(int id,int productId,int qty) {
		return objBaseDao.updateCart(id,productId,qty);
	}
	
	/*
	 * Definition of showProduct method 
	 */
	@Override
	public List<Product> showProduct() {
		return objBaseDao.showProduct();
	}

	/*
	 * Definition of showCart method 
	 */
	@Override
	public List<ShoppingCart> showCart(int id) {
		return objBaseDao.showCart(id);
	}

	/*
	 * Definition of checkLoginStatus method 
	 */
	@Override
	public boolean checkLoginStatus(int id, String pass) {
		return objBaseDao.checkLoginStatus(id, pass);	
	}

	/*
	 * Definition of addToProductToCart method 
	 */
	@Override
	public Status addToProductToCart(int id, int pId, int pQty) {
		return objBaseDao.addToProductToCart(id, pId,pQty);
	}
}
