package com.metacube.ead;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.ead.facade.Facade;
import com.metacube.ead.factory.FactoryPattern;
import com.metacube.ead.view.View;

public class TestForShoppingCart {

	@Test
	public void testForLogin() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertTrue(objFacade.checkLoginStatus(1, "1234")==true);
		assertTrue(objFacade.checkLoginStatus(2, "2345")==true);
		assertTrue(objFacade.checkLoginStatus(3, "3456")==true);
	}
	
	@Test
	public void testForLogin_InvalidIdOrPass() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertTrue(objFacade.checkLoginStatus(2, "1234")==false);
		assertTrue(objFacade.checkLoginStatus(1, "5634")==false);
		assertTrue(objFacade.checkLoginStatus(3, "1234")==false);
	}
	
	@Test
	public void ShowCart() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertTrue(objFacade.checkLoginStatus(1, "1234")==true);
		assertTrue(objFacade.checkLoginStatus(2, "2345")==true);
		assertTrue(objFacade.checkLoginStatus(3, "3456")==true);
	}

}
