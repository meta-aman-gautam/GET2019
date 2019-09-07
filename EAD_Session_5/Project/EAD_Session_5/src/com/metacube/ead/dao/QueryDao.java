package com.metacube.ead.dao;

/**
 * The Class QueryDao contains all the query related to database.{DAO LAYER}
 * 
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class QueryDao{
	
	/**
	 * Check login status of the user in the application .
	 *
	 * @param id 
	 * @param pass
	 * @return string
	 */
	public String checkLoginStatus(int id ,String pass) {	
		return "SELECT * FROM users WHERE userid = "+id+" and password = '"+pass+"'";
	}
	
	/**
	 * Show cart.
	 *
	 * @param id
	 * @return string
	 */
	public String showCart(int id) {	
		return "SELECT c.cartid as userid,p.productid,p.productname as ProductName ,p.producttype as ProductType ,"
				+"c.productquantity as quantity,p.price ,COUNT(p.productid) as NO_OF_PRODUCTS ,SUM(c.productquantity*p.price) as Total_Price FROM cart c" 
				+" INNER JOIN product p ON p.productid = c.productid"
				+" WHERE c.cartid ="+id 
				+" GROUP BY c.productid ";
	}
	
	/**
	 * Adds the product to cart of the logged in user.
	 *
	 * @param id 
	 * @param pid 
	 * @param pQty
	 * @return the string
	 */
	public String addProductToCart(int id ,int pid,int pQty) {
		return "INSERT into cart(cartid,productid,productquantity) VALUES ("+id+","+pid+","+pQty+")";
	}
	
	/**
	 * Display alll the Available products in the Shopping Store and there id for user to choose from .
	 *
	 * @return the string
	 */
	public String availableProducts() {
		return "SELECT * FROM product";
	}

	/**
	 * Show product of the user's cart.
	 *
	 * @return the string
	 */
	public String showProduct() {
		return "SELECT * FROM product";
	}

	/**
	 * Delete product in the database .
	 *
	 * @param id 
	 * @param productId 
	 * @param qty 
	 * @return the string
	 */
	public String deleteProduct(int id, int productId, int qty) {
		return "DELETE FROM cart WHERE productid = "+productId+" and cartid ="+id;
	}

	/**
	 * Update cart in the database .
	 *
	 * @param id 
	 * @param productId
	 * @param qty 
	 * @return the string
	 */
	public String updateCart(int id, int productId, int qty) {
		return "UPDATE cart "
				+"SET productquantity ="+qty
				+ " WHERE productid = "+productId+" and cartid ="+id;
	}
	
}
