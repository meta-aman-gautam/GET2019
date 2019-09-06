package com.metacube.ead.inventory.model;

// TODO: Auto-generated Javadoc
/**
 * Elements of Inventory method is used store the elements of the Inventory in
 * the Database .
 * 
 * @author Aman Gautam
 * 
 * DATED : 9/6/19
 *
 */
public class ItemsOfInventory {

	String itemName;
	int itemQuantity;

	/**
	 * Instantiates a new items of inventory.
	 *
	 * @param itemName 
	 * @param itemQuantity 
	 */
	public ItemsOfInventory(String itemName, int itemQuantity) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}

	/**
	 * Instantiates a new items of inventory.
	 */
	public ItemsOfInventory() {
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return the itemquantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 *
	 * @param itemQuantity
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
