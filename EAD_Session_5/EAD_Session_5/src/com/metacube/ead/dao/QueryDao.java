package com.metacube.ead.dao;

public class QueryDao {
	
	public String checkLoginStatus(int id ,String pass) {	
		return "SELECT * FROM users WHERE userid = "+id+" and password = '"+pass+"'";
	}
	
	public String showCart(int id) {	
		return "Select c.cartid as userid,p.productid,p.productname as ProductName ,p.producttype as ProductType ,"
				+"c.productquantity as quantity,p.price ,COUNT(p.productid) as NO_OF_PRODUCTS ,SUM(c.productquantity*p.price) as Total_Price FROM cart c" 
				+" INNER JOIN product p ON p.productid = c.productid"
				+" WHERE c.cartid ="+id 
				+" GROUP BY c.productid ";
	}
	
	public String addProductToCart() {
		return "";
	}
	
	
}
