package com.metacube.ead.controller;

import com.metacube.ead.facade.Facade;

public class Controller {

	Facade objFacade = new Facade();
	
	public boolean checkLoginStatus(int id, String pass) {
		return objFacade.checkLoginStatus(id,pass);
	}

	public String showCart(int id) {
		return objFacade.showCart(id);
	}

}
