package com.metacube.ead.view;

import java.util.Scanner;

import com.metacube.ead.controller.Controller;

public class Driver {

	public static void main(String[] args) {
		String pass ;
		int id;
		boolean loginStatus =false ;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id");
		id =sc.nextInt();
		System.out.println("Enter the Pass");
		pass =sc.next();
		
		Controller objController = new Controller();
		
		try {
			if(objController.checkLoginStatus(id,pass)==true) {
				System.out.println("Login Succesfull");
				loginStatus = true ;
				System.out.println("Select Choice [1/2/3/4] \n1- Add to cart \n2- Update Cart \n3- Display Cart");
				int choice = sc.nextInt();
				switch(choice) {
					case 1:
						
						break;
						
					case 2:
						break;
						
					case 3:
						System.out.println(objController.showCart(id));
						break;
				}
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
