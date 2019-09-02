package com.metacube.ead.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlDao implements BaseDao {

	QueryDao objQueryDao = new QueryDao();
	JdbcConnection objConnection =new JdbcConnection();
	
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

	@Override
	public void addProductToCart() {
		
	}

	@Override
	public String updateCart() {
		return null;
	}

	@Override
	public String showCart(int id) {
		String answer =null;
		String queryString = objQueryDao.showCart(id);
		try {
			PreparedStatement preStatement = objConnection.getObjConnection().prepareStatement(queryString);
			ResultSet resultSet = preStatement.executeQuery();
			answer="Product id    "+"Product Name  "+"  Product Type"+"    Qty "+"    Price   "+"No_Of_Products"+"Total_Price \n";
			while(resultSet.next()) { 
				answer =answer+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"
						+resultSet.getString(6)+"\t"+resultSet.getString(7)+"\t"+resultSet.getString(8)+"\n";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return answer ;
	}

	
	
	
}
