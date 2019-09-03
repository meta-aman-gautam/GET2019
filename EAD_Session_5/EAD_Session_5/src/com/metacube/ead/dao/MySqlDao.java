package com.metacube.ead.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;

import com.metacube.ead.enums.Status;
import com.metacube.ead.factory.FactoryPattern;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

/**
 * The Class MySqlDao.{DAO LAYER}
 * @author Aman Gautam
 */
public class MySqlDao implements BaseDao<Product> {

	QueryDao objQueryDao = (QueryDao) FactoryPattern.FactoryPatternObject("QueryDao");
	JdbcConnection objConnection =  (JdbcConnection) FactoryPattern.FactoryPatternObject("JdbcConnection");

	/**
	 * Definition of addToProductToCart method
	 * @return Status{enum}
	 */
	@Override
	public Status addToProductToCart(int id,int pId, int pQty) {
		if(pQty<=0){
			return Status.INVALID;
		}
		else{
			String queryString = objQueryDao.addProductToCart(id,pId, pQty);
			try{
				PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
				if(preStatement.executeUpdate()==1){
					return Status.ADDED;
				}
				else{
					return Status.ERROR;
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return Status.ERROR ;
			}
		}
	}

	/**
	 * Definition of updateCart method
	 * @return Status{enum}
	 */
	@Override
	public Status updateCart(int id,int productId,int qty) {
		if(qty<=0){
			String queryString = objQueryDao.deleteProduct(id,productId, qty);
			try {
				PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
				System.out.println(queryString);
				if(preStatement.executeUpdate()==1){
					return Status.DELETED;
				}
				else{
					return Status.ERROR;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return Status.ERROR;
			}
		}
		
		else{
			String queryString = objQueryDao.updateCart(id,productId,qty);
			try {
				PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
				int a = preStatement.executeUpdate();
				if(a==1){
					return Status.UPDATED;
				}
				else{
					return Status.ERROR;
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return Status.ERROR;
			}
		}	
	}
	
	/**
	 * Definition of showCart method
	 * @return List{ShoppingCart}
	 */
	@Override
	public List<ShoppingCart> showCart(int id) {
		List<ShoppingCart> cartList = new ArrayList<>();
		String queryString = objQueryDao.showCart(id);
		try{
			PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				cartList.add(new ShoppingCart(resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),
						resultSet.getInt(5),resultSet.getDouble(6),resultSet.getInt(7),resultSet.getDouble(8)));
			}
			return cartList;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * Definition of showProduct method
	 * @return List{Product}
	 */
	@Override
	public List<Product> showProduct() {
		List<Product> productList = new ArrayList<>();
		String queryString = objQueryDao.showProduct();
		try{
			PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				productList.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getFloat(3),resultSet.getString(4)));
			}
			return productList;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * Definition of checkLoginStatus method
	 * @return boolean
	 */
	@Override
	public boolean checkLoginStatus(int id, String pass) {
		String queryString = objQueryDao.checkLoginStatus(id, pass);
		try {
			PreparedStatement prestatement = objConnection.getObjConnection().prepareStatement(queryString);
			ResultSet resultSet = prestatement.executeQuery();
			resultSet.next();
			if(resultSet.getInt(1)==id && pass.equals(resultSet.getString(3))) {
				return true;
			}
			else {
				return false ;
			}
		} catch (SQLException e) {
			return false ;
		}	
		catch(Exception e) {
			return false;
		}
	}
}
