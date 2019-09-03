package com.metacube.ead.factory;

import com.metacube.ead.controller.Controller;
import com.metacube.ead.dao.JdbcConnection;
import com.metacube.ead.dao.ProductDao;
import com.metacube.ead.dao.QueryDao;
import com.metacube.ead.enums.DBTYPE;
import com.metacube.ead.facade.Facade;

/**
 * The Class FactoryPattern{Utility Layer}.
 * @author Aman Gautam
 */
public class FactoryPattern {
	
	/**
	 * method to create Factory pattern object  .
	 *
	 * @param input
	 * @return Factory pattern object
	 */
	public static Object FactoryPatternObject(String input){
		
		switch (input) {
		case "Controller":
			return new Controller();
			
		case "Facade":
			return new Facade();	
		
		case "QueryDao":
			return new QueryDao();
		
		case "JdbcConnection":
			return new JdbcConnection();	
		
		default:
			return null;
		}
	}
	
	/**
	 * Gets the product dao.
	 *
	 * @param dbType 
	 * @return the product
	 */
	public static ProductDao getProductDao(DBTYPE dbType){
		return new ProductDao(dbType);
	}

}
