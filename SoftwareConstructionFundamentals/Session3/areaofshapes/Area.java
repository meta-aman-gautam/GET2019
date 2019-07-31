package areaofshapes;

import java.util.*;

/**class calcluates the Area of shapes .
 * 
 * @author Aman Gautam
 * Dated 17/07/2019
 aman
 */
public class Area {
	
	// Initialization of MAIN Method 
	public static void main(String[] args) {
		
		int choice;
		double height,radius,width;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\nEnter your choice-\n1- [Area of Triangle]\n" + "2- [Area of Rectangle]\n"
					            + "3- [Area of circle]\n" + "4- [Area of square]\n" + "5- [To exit]");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter the height");
					height = sc.nextDouble();
					System.out.println("Enter the width");
					width =sc.nextDouble();
					System.out.println(areaofTriangle(height, width));
					break;
					//Assuming that Arithmetic Exception may occur.
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}

			case 2:
				try {
					System.out.println("Enter the height");
					height = sc.nextDouble();
					System.out.println("Enter the width");
					width =sc.nextDouble();
					System.out.println(areaofRectangle(height,width));
					break;
					//Assuming that Arithmetic Exception may occur.
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}

			case 3:
				try {
					System.out.println("Enter the Radius");
					radius = sc.nextDouble();
					System.out.println(areaofCircle(radius));
					break;
					//Assuming that Arithmetic Exception may occur.
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}
			case 4:
				try {
					System.out.println("Enter the width");
					width = sc.nextDouble();
					System.out.println(areaofSquare(width));
					break;
					//Assuming that Arithmetic Exception may occur.
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}

			case 5:
				System.exit(0);

			default:
				System.out.println("Invalid choice ... please try again");
				break;
			}
		} while (choice != 0);
		sc.close();
	}

	/**Area of triangle 
	 * 
	 * @param width
	 * @param height
	 * 
	 * @return resultant value
	 */
	public static double areaofTriangle(double width, double height) {
		double area ;
		area = 0.5*width*height;
		//precision upto two decimal places
		return  Math.round(area * 100.0) / 100.0;
	}
	
	/**
	 * Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * 
	 * @return resultant value
	 */
	public static double areaofRectangle(double width, double height) {
		double area ;
		area = width*height;
		//precision upto two decimal places
		return Math.round(area * 100.0) / 100.0;
	}

	/**Area of Circle
	 * 
	 * @param radius
	 * 
	 * @return resultant value
	 */
	public static double areaofCircle(double radius) {
		double area ;
		area = Math.PI * Math.pow(radius, 2);
		//precision upto two decimal places
		return  Math.round(area * 100.0) / 100.0;
	}
	
	/**
	 * Area of Square
	 * 
	 * @param width
	 * @return
	 */
	public static double areaofSquare(double width) {
		double area;
		area = Math.pow(width, 2);
		//precision upto two decimal places.
		return Math.round(area * 100.0) / 100.0;
	}
}
