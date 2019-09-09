package com.metacube.ead.inventory.facade;

import java.util.List;
import com.metacube.ead.inventory.dao.InventoryDao;
import com.metacube.ead.inventory.enums.DBtype;
import com.metacube.ead.inventory.model.ItemsOfInventory;

/**
 * The Class Facade here all the implemented query are written and created
 * as well as any business logic {if used} .
 * 
 * @author Aman Gautam
 * Dated : 9/6/19
 */
public class Facade {
	
	/* 
	 * The obj inventory gets the construction on InventoryDao.
	 */
	InventoryDao objInventory  = new InventoryDao(DBtype.MYSQL);
	
	/** The Constant DELETE_ALL_RESOURCE. */
	public static final String GET_ALL_ITEM = "SELECT * FROM inventory",
						       GET_BY_NAME ="SELECT * FROM inventory WHERE itemname = '",
						       ADD_NEW_RESOURCE = "INSERT into inventory(itemname,itemquantity) VALUES ('",
						       UPDATE_RESOURCE ="UPDATE inventory SET itemquantity = " ,
						       DELETE_RESOURCE_BY_NAME = "DELETE FROM inventory WHERE itemname = '" ,
						       DELETE_ALL_RESOURCE = "TRUNCATE TABLE inventory";
	
	
	/**
	 * Gets the all items.
	 *
	 * @return items list
	 */
	public List<ItemsOfInventory> getAllItems(){
		return objInventory.getAllItems(GET_ALL_ITEM);
	}

	/**
	 * Gets the item by name.
	 *
	 * @param itemName
	 * @return {ItemsOfInventory}
	 */
	public ItemsOfInventory getItemByName(String itemName) {
		return objInventory.getItemByName(GET_BY_NAME+itemName+"'");
	}

	/**
	 * Adds the new resource to inventory.
	 *
	 * @param itemName
	 * @param itemQuantity
	 * @return string
	 */
	public String addNewResource(String itemName, int itemQuantity) {
		return objInventory.addNewResource(ADD_NEW_RESOURCE+itemName+"','"+itemQuantity+"')");
	}

	/**
	 * Update resource in the inventory by NAME.
	 *
	 * @param itemName
	 * @param itemQuantity
	 * @return string
	 */
	public String updateResource(String itemName, int itemQuantity) {
		return objInventory.updateResource(UPDATE_RESOURCE+itemQuantity+" WHERE itemname = '"+itemName+"';");
	}
	
	/**
	 * Update all resource in the inventory.
	 *
	 * @param itemName
	 * @param itemQuantity
	 * @return string
	 */
	public String updateAllResource(String itemName, int itemQuantity) {
		return objInventory.updateResource(UPDATE_RESOURCE+itemQuantity+" WHERE itemname = '"+itemName+"';");
	}

	/**
	 * Deletes all resources in the inventory.
	 *
	 * @return the boolean
	 */
	public Boolean deleteAllResources(){
		return objInventory.deleteAllItems(DELETE_ALL_RESOURCE);
	}

	/**
	 * Delete resource in the inventory by name.
	 *
	 * @param itemName
	 * @return true, if successful
	 */
	public boolean deleteResourceByName(String itemName) {
		return objInventory.deleteResourceByName(DELETE_RESOURCE_BY_NAME+itemName+"';");
	}
}
