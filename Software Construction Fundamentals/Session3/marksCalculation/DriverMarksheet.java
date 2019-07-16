package marksCalculation;

import java.util.*;

public class DriverMarksheet {

	public static void main(String[] args) {
		
		int choice;

		Scanner sc = new Scanner(System.in);

		
		Marksheet obj = new Marksheet();
		obj.input();
		do {
			System.out.println("Enter your choice-\n"
								+ "1- [Average of all grades.]\n" 
								+ "2- [Maximum of all grades]\n"
								+ "3- [Minimum of all grades]\n"
								+ "4- [Percentage of students passed. (Assume grade >= 40 as Pass)]\n" + "5- [To exit]");
			
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println(obj.average());
					break;
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}

			case 2:
				try {
					System.out.println(obj.maximum());
					break;
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break;
				}

			case 3:
				try {
					System.out.println(obj.minimum());
					break;
				} catch (ArithmeticException e) {
					System.out.println("You Shouldn't divide a number by zero");
					break ;
				}
			case 4:
				try {
					System.out.println(obj.passedPercentage());
					break;
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

}
