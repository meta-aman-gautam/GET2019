package hexadecimalConversion;

import java.util.Scanner;

/**
 * Driver class is the base class for the package hexadecimalConversion .
 *
 * @auther Aman Gautam
 * 
 * dated 15/07/2019
 */
public class HexCalc_Driver {
	
	//Initialization of main method
	public static void main(String[] args) {
		/*
		 * First Number {String} 
		 * Second Number{String} 
		 * HexNumber{String} is used to get hexadecimal no as an input.
		 */
		int choice, choice1, choice3, DecimalNumber;
		String HexNumber, FirstNumber, SecondNumber;
		
		Scanner sc = new Scanner(System.in);
	
		//object of HexCalc class is created in order to access its methods
		HexCalc obj = new HexCalc();
		
		System.out.println("[1 - For Arthmetic operations (Add/Sub/Multiply/Divide)\n"
						+ "[2 - For comparing Strings ('==','<','>') ]\n"
						+ "[3 - For Decimal to Hexadecimal conversion ]\n"
						+ "[4 - For Hexadecimal to Decimal conversion ]");

		do {
			System.out.println("\nEnter your choice from above");
			choice = sc.nextInt();
			switch (choice) {

		   /*
			* case 1 - For Arithmetic operations such as(Add/Sub/Multiply/Divide)
			* result will come in HEXADECIMAL format for every operation .
			*/
			case 1: 
				System.out.println("1 - Addition\n"
								+ "2 - Subtraction\n"
								+ "3 - Multiplication\n"
								+ "4 - Division\n");
				choice1 = sc.nextInt();
				if (choice1 == 1) {
					System.out.println("Answer : " + obj.addition());
				} else if (choice1 == 2) {
					System.out.println("Answer : " + obj.subtraction());
				} else if (choice1 == 3) {
					System.out.println("Answer : " + obj.multiplication());
				} else if (choice1 == 4) {
					System.out.println("Remainder = " + obj.division());
				} else {
					System.out.println("Invalid choice");
				}
				break;
			
			/*
			 * CASE 2 - For two HEXADECIMAL no. COMPARISON such "==" , ">" or "<" .
			 * 
			 * return value{boolean};
			 */
			case 2: 
				System.out.println("Enter two hexadecimal nos.");
				System.out.print("first no -");
				FirstNumber = sc.next();
				System.out.print("second no - ");
				SecondNumber = sc.next();
				System.out.println("choose:\n"+
								"'1' checks first no. == second no.\n"   +
								"'2' for checks first no. > second no.\n"+
								"'3' for checks first no. < second no.");
				
				choice3 = sc.nextInt();
				if (choice3 == 1) {
					System.out.println(obj.isEqual(FirstNumber, SecondNumber));
				}
				if (choice3 == 2) {
					System.out.println(obj.isGreater(FirstNumber, SecondNumber));
				}
				if (choice3 == 3) {
					System.out.println(obj.isSmaller(FirstNumber, SecondNumber));
				}
				break;

			/*
			 * CASE 3 - For Conversion of DECIMAL no to HEXADECIMAL no .
			 *
			 * Decimal number is input
			 * 
			 * Hexadecimal number is return value
			 */
			case 3: 
				System.out.println("Enter the DECIMAL no.  ");
				DecimalNumber = sc.nextInt();
				System.out.println("Hexadecimal Equivalent = " + obj.getHex(DecimalNumber));
				break;

			/*
			 * CASE 4 - For Conversion of HEXADECIMAL no. to DECIMAL no .
			 * 
			 * Decimal no is input
			 * Hexadecimal equivalent is return value
			 */
			case 4: {
				System.out.println("Enter the HEXADECIMAL no.  ");
				HexNumber= sc.next();
				System.out.println("Decimal Equivalent = " + obj.getDecimal(HexNumber));
				break;
			}
			default: {
				System.out.println("INVALID CHOICE --- Please try Again .");
				break;
			}
			}
		} while (choice != 0);
		sc.close();
	}

}