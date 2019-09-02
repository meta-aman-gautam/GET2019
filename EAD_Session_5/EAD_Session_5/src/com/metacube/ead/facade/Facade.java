package com.metacube.ead.facade;

import com.metacube.ead.dao.MySqlDao;

public class Facade {
	
	MySqlDao objmySqlDao = new MySqlDao();
	
	public boolean checkLoginStatus(int id, String pass) {
		return objmySqlDao.checkLoginStatus(id,pass);
	}

	public String showCart(int id) {
		return objmySqlDao.showCart(id);
	}

	

}
