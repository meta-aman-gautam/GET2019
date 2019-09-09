package com.metacube.ead.inventory.dao;

import java.util.List;

import com.metacube.ead.inventory.enums.DBtype;
import com.metacube.ead.inventory.model.ItemsOfInventory;

/**
 * The Class InventoryDao where the constructor create the appropriate choice for the 
 * Database type which is eventually returned to the facade dao.
 */
public class InventoryDao implements BaseDao<ItemsOfInventory> {
  
	BaseDao<ItemsOfInventory> baseDao ;
	
	/**
	 * Instantiates a new inventory Dao.
	 *
	 * @param dbtype
	 */
	public InventoryDao(DBtype dbtype) {
		if(dbtype == DBtype.MYSQL){
			baseDao = new MySqlDao();
		}
		else{
			baseDao = new InMemoryDao();
		}
	}

	/**
	 * Implemented method where we get all the items .
	 */
	@Override
	public List<ItemsOfInventory> getAllItems(String inputQuery) {
		return baseDao.getAllItems(inputQuery);
	}

	/**
	 * Implemented method where we get all the items by Name .
	 */
	@Override
	public ItemsOfInventory getItemByName(String inputQuery) {
		return baseDao.getItemByName(inputQuery);
	}

	/**
	 * Implemented method where we delete all the items by Name .
	 */
	@Override
	public boolean deleteAllItems(String inputQuery) {
		return baseDao.deleteAllItems(inputQuery);
	}

	/**
	 * Implemented method where we add the items in the inventory .
	 */
	public String addNewResource(String inputQuery) {
		return baseDao.addNewResource(inputQuery);
	}

	/**
	 * Implemented method where we update the items in the inventory .
	 */
	public String updateResource(String inputQuery) {
		return baseDao.updateResource(inputQuery);
	}
	
	/**
	 * Implemented method where we delete the items in the inventory by Name .
	 */
	public boolean deleteResourceByName(String inputQuery) {
		return baseDao.deleteResourceByName(inputQuery);
	}

}
