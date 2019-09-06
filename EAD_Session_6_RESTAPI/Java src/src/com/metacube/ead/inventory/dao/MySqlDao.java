package com.metacube.ead.inventory.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.ead.inventory.model.ItemsOfInventory;

/**
 * The Class MySqlDao all the query execution is here .
 */
public class MySqlDao implements BaseDao<ItemsOfInventory> {

	/** The connection. */
	JdbcConnection connection = new JdbcConnection();
	
	/**
	 * Get all items in the inventory
	 */
	@Override
	public List<ItemsOfInventory> getAllItems(String inputQuery) {
		List<ItemsOfInventory> listOfItems = new ArrayList<>() ;
		try {
			PreparedStatement preStatement = connection.getObjConnection().prepareStatement(inputQuery) ;
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				listOfItems.add(new ItemsOfInventory(resultSet.getString(1), resultSet.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			return null ;
		}
		return listOfItems;
	}

	/**
	 * Get item in the inventory by Name
	 */
	@Override
	public ItemsOfInventory getItemByName(String inputQuery) {
		try{
			PreparedStatement preStatement = connection.getObjConnection().prepareStatement(inputQuery);
			ResultSet resultSet = preStatement.executeQuery();
			resultSet.next();
			return new ItemsOfInventory(resultSet.getString(1), resultSet.getInt(2));
		}
		catch(SQLException e){
			return null;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Add the new resource in the inventory by Name
	 */
	@Override
	public String addNewResource(String inputQuery) {
		try{
			PreparedStatement preStatement = connection.getObjConnection().prepareStatement(inputQuery);
			int resultSet = preStatement.executeUpdate();
			if(resultSet>0){
				return "NEW RESOURCE ADDED" ;
			}else{
				return "ERROR";
			}
		}
		catch(Exception e){
			return null;
		}
	}

	/**
	 * update the entire inventory in the inventory by Name
	 */
	@Override
	public String updateResource(String inputQuery) {
		PreparedStatement preStatement;
		try {
			preStatement = connection.getObjConnection().prepareStatement(inputQuery);
			int resultSet = preStatement.executeUpdate();
			if(resultSet>0){
				return "RESOURCE UPDATE";
			}
			else{
				return "ERROR";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
	}

	/**
	 * Delete all the items in the inventory 
	 */
	@Override
	public boolean deleteAllItems(String inputQuery) {
		try {
			PreparedStatement preStatement = connection.getObjConnection().prepareStatement(inputQuery);
			if(preStatement.executeUpdate()==0){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete all the items in the inventory by name 
	 */
	@Override
	public boolean deleteResourceByName(String inputQuery){
		try {
			PreparedStatement preStatement = connection.getObjConnection().prepareStatement(inputQuery);
			if(preStatement.executeUpdate()==0){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
