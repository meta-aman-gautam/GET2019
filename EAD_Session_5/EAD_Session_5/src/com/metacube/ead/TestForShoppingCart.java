package com.metacube.ead;

import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.ead.facade.Facade;
import com.metacube.ead.factory.FactoryPattern;

/**
 * The Class Test For Shopping Cart.
 * @author Aman Gautam
 * Dated :9/6/19
 */
public class TestForShoppingCart {

	/**
	 * Test for login.
	 */
	@Test
	public void testForLogin() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertTrue(objFacade.checkLoginStatus(1, "1234")==true);
		assertTrue(objFacade.checkLoginStatus(2, "2345")==true);
		assertTrue(objFacade.checkLoginStatus(3, "3456")==true);
	}
	
	/**
	 * Test for login invalid id or pass.
	 */
	@Test
	public void testForLogin_InvalidIdOrPass() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertTrue(objFacade.checkLoginStatus(2, "1234")==false);
		assertTrue(objFacade.checkLoginStatus(1, "5634")==false);
		assertTrue(objFacade.checkLoginStatus(3, "1234")==false);
	}
	
	/**
	 * Test for Add Product to Cart
	 */
	@Test
	public void testForAddProductToCart() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertEquals(com.metacube.ead.enums.Status.ADDED ,objFacade.addProductToCart(1, 3, 33));
		assertEquals(com.metacube.ead.enums.Status.ERROR,objFacade.addProductToCart(1, 2, 33));
	}
	
	/**
	 * Test for Updation in Cart
	 */
	@Test
	public void testForUpdateCart() {
		Facade objFacade =  (Facade) FactoryPattern.FactoryPatternObject("Facade");
		assertEquals(com.metacube.ead.enums.Status.UPDATED,objFacade.updateCart(1, 2, 33));
		assertEquals(com.metacube.ead.enums.Status.ERROR ,objFacade.updateCart(1 ,5, 32));
	}
	
}
