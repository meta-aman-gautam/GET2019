package question1;

import java.util.*;

public class HexCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice, choice1, choice3, no;

		/*
		 * A is first no. integer type B is second no. integer type hex is used to get
		 * hexadecimal no (String type)
		 */
		String hex, A, B;

		Scanner sc = new Scanner(System.in);

		/*
		 * object of Hex_to_decimal class is created in order access its methods
		 */
		Hex_to_decimal obj = new Hex_to_decimal();

		System.out.println("[1 - For Arthmetic operations (Add/Sub/Multiply/Divide) \n"
				+ "[2 - For comparing Strings ('==','<','>') ]\n" + "[3 - For Decimal to Hexadecimal conversion ]\n"
				+ "[4 - For Hexadecimal to Decimal conversion ]");

		do {
			System.out.println("\nEnter your choice from above");
			choice = sc.nextInt();
			switch (choice) {

			// case 1 - For Arithmetic operations such as (Add/Sub/Multiply/Divide)
			// result will come in HEXADECIMAL format for every operation .
			case 1: {
				System.out.println("1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\n");
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
			}

			// CASE 2 - For two HEXADECIMAL no. COMPARISON such "==" , ">" or "<"
			case 2: {

				System.out.println("Enter two hexadecimal nos.");
				System.out.println("first no -");
				A = sc.next();
				System.out.println("second no - ");
				B = sc.next();
				System.out.println(
						"choose:\n'1' checks first no. == second no. \n'2' for checks first no. > second no.\n'3' for checks first no. < second no.");
				choice3 = sc.nextInt();
				if (choice3 == 1) {
					System.out.println(obj.isEqual(A, B));
				}
				if (choice3 == 2) {
					System.out.println(obj.isGreater(A, B));
				}
				if (choice3 == 3) {
					System.out.println(obj.isSmaller(A, B));
				}

				break;
			}

			// CASE 3 - For Conversion of DECIMAL no to HEXADECIMAL no .
			case 3: {

				System.out.println("Enter the DECIMAL no.  ");
				no = sc.nextInt();
				System.out.println("Hexadecimal = " + obj.getHex(no));

				break;
			}

			// CASE 4 - For Conversion of HEXADECIMAL no to DECIMAL no .
			case 4: {
				System.out.println("Enter the HEXADECIMAL no.  ");
				hex = sc.next();
				System.out.println(obj.getDecimal(hex));

				break;

			}
			default: {
				System.out.println("INVALID CHOICE ---Please try Again .");

				break;
			}
			}
		} while (choice != 0);
	}

}
