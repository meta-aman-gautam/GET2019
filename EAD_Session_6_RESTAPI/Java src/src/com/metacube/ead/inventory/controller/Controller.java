package com.metacube.ead.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.metacube.ead.inventory.facade.Facade;
import com.metacube.ead.inventory.model.ItemsOfInventory;

/**
 * The Class Controller is the second layer which passes the inputs to 
 * facade layer and further .
 * 
 * @author Aman Gautam
 * 
 * DATED : 9/6/19
 */
@Path("/inventory")
public class Controller {


	Facade objFacade = new Facade();
	
	/**
	 * Show GET method inventory items.
	 *
	 * @return the string
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String showInventory() {
		String answer = null;
		List<ItemsOfInventory> listOfItems = new ArrayList<>();
		listOfItems = objFacade.getAllItems();
		Gson gson = new Gson();
		if(listOfItems.size()> 0){
			 answer= gson.toJson(listOfItems);
		}
		else{
			answer = "INVALID";
		}
		return answer;
	}
	
	/**
	 * Show item by name GET METHOD.
	 *
	 * @param itemName the item name
	 * @return the string
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	@Path("{itemName}")
	public String showItemByName(@PathParam("itemName") String itemName){
		String answer = null;
		ItemsOfInventory objItem ;
		objItem = objFacade.getItemByName(itemName);
		Gson gson = new Gson();
		if(objItem != null){
			answer = gson.toJson(objItem);
		}
		else{
			answer = "INVALID";
		}
		return answer;
	}
	
	/**
	 * Adds the new resource in the inventory POST METHOD.
	 *
	 * @param inventory the inventory
	 * @return the string
	 */
	@POST
	public String addNewResource(ItemsOfInventory inventory){
		String itemName =  inventory.getItemName();
		int itemQuantity = inventory.getItemQuantity();
		return objFacade.addNewResource(itemName,itemQuantity);
	}
	
	/**
	 * Update item by name in the inventory PUT METHOD.
	 *
	 * @param itemNamePath the item name path
	 * @param inventory the inventory
	 * @return the string
	 */
	@PUT
	@Path("{itemName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateItemByName(@PathParam("itemName") String itemNamePath,ItemsOfInventory inventory){
		int itemQuantity= inventory.getItemQuantity();
		return objFacade.updateResource(itemNamePath,itemQuantity);
	}

	/**
	 * Update all resource in the inventory PUT Method.
	 *
	 * @param inventory the inventory
	 * @return the string
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String updateAllResource(String inventory) {
		Gson gson = new Gson();
		TypeToken<List<ItemsOfInventory>> token  = new TypeToken<List<ItemsOfInventory>>(){};
		List<ItemsOfInventory> inventoryList =gson.fromJson(inventory, token.getType());
		if(objFacade.deleteAllResources()==true){
			for(int i=0;i<inventoryList.size();i++){
				String itemName = inventoryList.get(i).getItemName();
				int itemQuantity = inventoryList.get(i).getItemQuantity(); 
				objFacade.addNewResource(itemName, itemQuantity);
			}
			return "INVENTORY UPDATED";
		}
		else{
			return "ERROR";
		}
	}
	
	/**
	 * Delete all resource in the inventory DELETE METHOD.
	 *
	 * @return the string
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAllResource() {
		if(objFacade.deleteAllResources()==true){
			return "INVENTORY DELETED";
		}
		else{
			return "ERROR";
		}
	}
	
	/**
	 * Delete item by name in the invemtory DELETE METHOD.
	 *
	 * @param itemName the item name
	 * @return the string
	 */
	@DELETE
	@Path("{itemName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteItemByName(@PathParam("itemName") String itemName) {
		if(objFacade.deleteResourceByName(itemName)==true){
			return "ITEM DELETED";
		}
		else{
			return "ERROR";
		}
	}
}
