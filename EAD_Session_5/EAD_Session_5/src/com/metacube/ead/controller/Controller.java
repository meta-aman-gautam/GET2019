package com.metacube.ead.controller;

import java.util.List;

import com.metacube.ead.enums.Status;
import com.metacube.ead.facade.Facade;
import com.metacube.ead.factory.FactoryPattern;
import com.metacube.ead.model.Product;
import com.metacube.ead.model.ShoppingCart;

public class Controller {

	
	Facade objFacade = (Facade) FactoryPattern.FactoryPatternObject("Facade");
	
	public boolean checkLoginStatus(int id, String pass) {
		return objFacade.checkLoginStatus(id,pass);
	}

	public List<ShoppingCart> showCart(int id) {
		return objFacade.showCart(id);
	}
	
	public List<Product> showProduct() {
		return objFacade.showProduct();
	}

	public Status updateCart(int userID,int productId,int qty) {
		return objFacade.updateCart(userID,productId,qty);
		
	}

	public Status addToProductToCart(int id,int pId, int pQty) {
		return objFacade.addProductToCart(id,pId,pQty);
	}

	

}
