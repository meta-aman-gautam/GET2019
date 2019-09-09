package com.metacube.ead.view;

import com.metacube.ead.factory.FactoryPattern;

/**
 * The Class Main which redirects you to the View layer .
 * This application will be a shopping cart application that will have products which should contain 
 * at least the Product Code ,Type ,Name ,Price .
 * Please login via your id and password to access and update your cart .
 * 
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class Main {

	/**
	 * The main method initialization .
	 *
	 * @param args 
	 */
	public static void main(String[] args) {
		//creation of the object using the factory pattern 
		View objView = (View) FactoryPattern.FactoryPatternObject("View");
		objView.displayInput(args);
	}

}
