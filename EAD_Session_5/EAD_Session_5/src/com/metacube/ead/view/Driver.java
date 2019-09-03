package com.metacube.ead.view;

import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.metacube.ead.controller.Controller;
import com.metacube.ead.enums.Status;
import com.metacube.ead.factory.FactoryPattern;

/**
 * The Driver Class{VIEW LAYER}.
 * @author Aman Gautam
 */
public class Driver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String pass ;
		int id;
		boolean loginStatus =false ;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id");
		id =sc.nextInt();
		System.out.println("Enter the Pass");
		pass =sc.next();
		
		Controller objController = (Controller) FactoryPattern.FactoryPatternObject("Controller");
		
		try {
			if(objController.checkLoginStatus(id,pass)) {
				System.out.println("Login Succesfull");
				loginStatus = true ;
				System.out.println("Select Choice [1/2/3/4] \n1- Add to cart \n2- Update Cart \n3- Display Cart");
				int choice = sc.nextInt();
				switch(choice) {
					case 1:
						System.out.println("Available Products are :\n");
						System.out.println("Product Id \tProduct Name");
						System.out.println("---------- \t------------");
						for(int i =0;i<objController.showProduct().size();i++){
							System.out.print(objController.showProduct().get(i).getProductId()+"\t\t");
							System.out.println(objController.showProduct().get(i).getProductName());
						}
						System.out.println("---------- \t------------");
						
						System.out.println("Choose Product Id");
						int pId = sc.nextInt();
						System.out.println("Choose Product Qty");
						int pQty =sc.nextInt();
						System.out.println(objController.addToProductToCart(id,pId, pQty));
						break;
						
					case 2:
						System.out.println("Available Product are:");
						System.out.println("Product Id \tProduct Name");
						System.out.println("---------- \t------------");
						for(int i =0;i<objController.showProduct().size();i++){
							System.out.print(objController.showProduct().get(i).getProductId()+"\t\t");
							System.out.println(objController.showProduct().get(i).getProductName());
						}
						System.out.println("---------- \t------------");
						
						System.out.println("Choose Product Id");
						int productId = sc.nextInt();
						System.out.println("Choose Product Qty");
						int productQty =sc.nextInt();
						
						System.out.println(objController.updateCart(id ,productId, productQty));
						
						break;
						
					case 3:
						for(int i =0;i<objController.showCart(id).size();i++){
							System.out.print(objController.showCart(id).get(i).getProductId()+"\t");
							System.out.print(objController.showCart(id).get(i).getProductName()+"\t");
							System.out.print(objController.showCart(id).get(i).getProductType()+"\t");
							System.out.print(objController.showCart(id).get(i).getProductQuantity()+"\t");
							System.out.print(objController.showCart(id).get(i).getPrice()+"\t");
							System.out.print(objController.showCart(id).get(i).getNoOfProducts()+"\t");
							System.out.print(objController.showCart(id).get(i).getTotalPrice()+"\n");
						}
						break;
						
						
					default :
						System.out.println(Status.INVALID);
				}	
				main(args);
			}
			else {
				System.out.println("Incorrect User Id or PassWord try again");
				loginStatus = false ;
				main(args);
			}
		}
		catch(Exception e) {
			loginStatus = false ;
		}
	}
}
