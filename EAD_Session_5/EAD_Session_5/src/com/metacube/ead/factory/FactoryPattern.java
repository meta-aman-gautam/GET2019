package com.metacube.ead.factory;

import com.metacube.ead.controller.Controller;
import com.metacube.ead.dao.JdbcConnection;
import com.metacube.ead.dao.ProductDao;
import com.metacube.ead.dao.QueryDao;
import com.metacube.ead.enums.DBTYPE;
import com.metacube.ead.facade.Facade;
import com.metacube.ead.view.View;

/**
 * The Class FactoryPattern{Utility Layer}.
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class FactoryPattern {
	
	private static View objView = null;
	private static Controller objController = null;
	private static Facade objFacade = null ;
	private static QueryDao objQueryDao =null;
	private static JdbcConnection objConnection =null;
	private static ProductDao objProductDao =null;
	
	private FactoryPattern(){} 
	
	/**
	 * method to create Factory pattern object  .
	 *
	 * @param input
	 * @return Factory pattern object
	 */
	public static Object FactoryPatternObject(String input){
		
		switch (input) {
		case "View":
			if(objView ==null){
				objView = new View() ;
				return objView;
			}
			else{
				return objView ;
			}
		case "Controller":
			if(objController ==null){
				objController = new Controller() ;
				return objController;
			}
			else{
				return objController ;
			}
			
		case "Facade":
			if(objFacade ==null){
				objFacade = new Facade() ;
				return objFacade;
			}
			else{
				return objFacade ;
			}
		
		case "QueryDao":
			if(objQueryDao ==null){
				objQueryDao = new QueryDao() ;
				return objQueryDao;
			}
			else{
				return objQueryDao ;
			}
		
		case "JdbcConnection":
			if(objConnection == null ){
				objConnection =new JdbcConnection();
				return objConnection;
			}
			else{
				return objConnection;
			}
		
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
		if(objProductDao==null){
			objProductDao = new ProductDao(dbType);
			return objProductDao;
		}
		else{
			return objProductDao ;
		}
	}
}
