package com.metacube.ead.inventory.dao;

import java.util.List;
import com.metacube.ead.inventory.model.ItemsOfInventory;

/**
 * The Interface BaseDao.
 * 
 * @author Aman Gautam
 * 
 * DATED : 9/6/19
 *
 */
public interface BaseDao<T> {
	
	/**
	 * Gets the all items.
	 *
	 * @param inputQuery the input query
	 * @return the all items{List}
	 */
	public List<ItemsOfInventory> getAllItems(String inputQuery);
	
	/**
	 * Gets the item by name.
	 *
	 * @param inputQuery
	 * @return the item
	 */
	public ItemsOfInventory getItemByName(String inputQuery);
	
	/**
	 * Adds the new resource.
	 *
	 * @param inputQuery 
	 * @return the string
	 */
	public String addNewResource(String inputQuery);
	
	/**
	 * Update resource.
	 *
	 * @param inputQuery
	 * @return the string
	 */
	public String updateResource(String inputQuery);
	
	/**
	 * Delete all items.
	 *
	 * @param inputQuery the input query
	 * @return true, if successful
	 */
	public boolean deleteAllItems(String inputQuery);
	
	/**
	 * Delete resource by name.
	 *
	 * @param inputQuery the input query
	 * @return true, if successful
	 */
	public boolean deleteResourceByName(String inputQuery);
}
