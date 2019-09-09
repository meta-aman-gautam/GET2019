package com.metacube.ead.view;

import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.metacube.ead.controller.Controller;
import com.metacube.ead.enums.Status;
import com.metacube.ead.factory.FactoryPattern;

/**
 * This application will be a shopping cart application that will have products which should contain 
 * at least the Product Code ,Type ,Name ,Price .
 * Please login via your id and password to access and update your cart .
 * 
 * The View Class{VIEW LAYER}.
 * 
 * @author Aman Gautam
 * Dated : 9/7/19
 */
public class View {

	private static boolean loginStatus = false;

	/**
	 * The Initialization of the main method.
	 *
	 * @param args
	 *         
	 */
	public void displayInput(String[] args) {
		String pass;
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Your User Id and Password to loginIn into Your Cart");
		System.out.println("\nEnter the id");
		id = sc.nextInt();
		System.out.println("Enter the Pass");
		pass = sc.next();
		Controller objController = (Controller) FactoryPattern.FactoryPatternObject("Controller");
		if (objController.checkLoginStatus(id, pass) == true) {
			loginStatus = true;
		}
		try {
			System.out.println("\nLogin Succesfull");
			while (loginStatus ) {
				System.out.println("\nSelect Choice [1/2/3/4] \n1- Add to cart \n2- Update Cart \n3- Display Cart\n4- Log Out");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					int productId,productQty ;
					System.out.println("Available Products are :\n");
					System.out.println("Product Id \tProduct Name");
					System.out.println("---------- \t------------");
					for (int i = 0; i < objController.showProduct().size(); i++) {
						System.out.print(objController.showProduct().get(i).getProductId()+ "\t\t");
						System.out.println(objController.showProduct().get(i).getProductName());
					}
					System.out.println("---------- \t------------");
					System.out.println("Choose Product Id");
					productId = sc.nextInt();
					System.out.println("Choose Product Qty");
					productQty = sc.nextInt();
					System.out.println(objController.addToProductToCart(id,productId, productQty));
					break;

				case 2:
					int productId1,productQty1 ;
					System.out.println("Available Product are:");
					System.out.println("Product Id \tProduct Name");
					System.out.println("---------- \t------------");
					for (int i = 0; i < objController.showProduct().size(); i++) {
						System.out.print(objController.showProduct().get(i).getProductId()+ "\t\t");
						System.out.println(objController.showProduct().get(i).getProductName());
					}
					System.out.println("---------- \t------------");
					System.out.println("Choose Product Id");
					productId1 = sc.nextInt();
					System.out.println("Choose Product Qty");
					productQty1 = sc.nextInt();
					System.out.println(objController.updateCart(id, productId1,productQty1));
					break;

				case 3:
					System.out.print("ProductId");
					System.out.print("ProductName");
					System.out.print("ProductType");
					System.out.print("ProductQuantity");
					System.out.print("Price");
					System.out.print("NoOfProducts");
					System.out.println("TotalPrice");
					for (int i = 0; i < objController.showCart(id).size(); i++) {
						System.out.print(objController.showCart(id).get(i).getProductId()+ "\t");
						System.out.print(objController.showCart(id).get(i).getProductName()+ "\t");
						System.out.print(objController.showCart(id).get(i).getProductType()+ "\t");
						System.out.print(objController.showCart(id).get(i).getProductQuantity()+ "\t");
						System.out.print(objController.showCart(id).get(i).getPrice()+ "\t");
						System.out.print(objController.showCart(id).get(i).getNoOfProducts()+ "\t");
						System.out.print(objController.showCart(id).get(i).getTotalPrice()+ "\n");
						}
					break;
					
				case 4:
					System.out.println("You Have Logged Out!");
					loginStatus = false;
					break;

				default:
					System.out.println(Status.INVALID);
					break;
				}
			}
			displayInput(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			displayInput(args);
		}
	}
}
