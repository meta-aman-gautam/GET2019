package StringOperations;

import java.util.*;

/**performs various string Operations.
 * 
 * @author Aman Gautam
 * dated 17/07/2019
 */
public class StringsOperations {

	/**
	 * This method compares two string [if equal then returns 1 else 0]
	 * 
	 * @param {String}FirstString
	 * @param {String}SecondString
	 * 
	 * @return boolean value
	 */
	public static int compare(String FirstString, String SecondString) {
		int count = 0;
		String greater;
		
		if (FirstString.length() != SecondString.length()) {
			return 0;
		} else {
			if (FirstString.length() > SecondString.length())
				greater = FirstString;
			else {
				greater = SecondString;
				SecondString = FirstString;
			}
			for (int index = 0; index < greater.length(); index++) {
				if (greater.charAt(index) != SecondString.charAt(index)) {
					return 0;
				} else {
					count++;
					if (count == greater.length()) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

	/**
	 * reverse method reverses the input string .
	 * 
	 * @param {string}FirstString   - input string at run time
	 * 
	 * @return {string}SecondString   -reversed string
	 */
	public static String reverse(String FirstString) {
		String SecondString = "";
		
		for (int count = 0; count < FirstString.length(); count++) {
			if (FirstString.charAt(count) == ' ') {
				SecondString = ' ' + SecondString;
			} else {
				SecondString = FirstString.charAt(count) + SecondString;
			}
		}
		return SecondString;
	}
	
	/**
	 * this method replaces lowercase characters with uppercase and vice-versa
	 * in the string.
	 * 
	 * @param {string}FirstString  -  input string at run time
	 *            
	 * @return {string}SecondString - Uppercase character switch with lowercase and vice verse
	 */
	public static String caseInversion(String FirstString) {
		String SecondString = "";
		
		for (int count = 0; count < FirstString.length(); count++) {
			if (FirstString.charAt(count) >= 65 && FirstString.charAt(count) <= 91) {
				SecondString = SecondString+ (char) (FirstString.charAt(count) + 32);
				
			} else if (FirstString.charAt(count) >= 97 && FirstString.charAt(count) <= 122) {
				SecondString = SecondString+ (char) (FirstString.charAt(count) - 32);
				
			} else if (FirstString.charAt(count) == ' ') {
				SecondString = SecondString + ' ';
			}
		}
		return SecondString;
	}
	
	/**
	 * this method returns the largest word of a string , if last two word have
	 * same length then it return the last word.
	 * 
	 * @param {string}FirstString
	 *           
	 * @return {string} greatest  - largest word of the string is the output
	 */
	public static String largestWord(String FirstString) {
		String SecondString = "";
		String greatest = "";

		for (int count = 0; count < FirstString.length(); count++) {
			if (FirstString.charAt(count) == ' ') {
				if (greatest.length() <= SecondString.length()) {
					greatest = SecondString;
					SecondString = "";
				} else {
					SecondString = "";
				}
			}
			else {
				SecondString += FirstString.charAt(count);
			}
		}
		if (greatest.length() <= SecondString.length()) {
			greatest = SecondString;
			SecondString = "";
		}
		return greatest;
	}
	
	/**
	 * Initialization of the main method 
	 * @param args
	 */
	public static void main(String[] args) {

		int choice1;
		String FirstString, SecondString;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\nENTER YOUR CHOICE :\n"
							+ "1- Compare two strings.\n"
							+ "2- Return the reverse of any string\n"
							+ "3- Replace lowercase characters with uppercase and vice-versa in a String\n"
							+ "4- Return the largest word of a string");

			choice1 = sc.nextInt();
			
			//BUG in java *** this input is useless .
			FirstString = sc.nextLine();

			switch (choice1) {

			case 1:
				System.out.print("Enter the first string -");
				FirstString = sc.nextLine();
				System.out.print("Enter the second string -");
				SecondString = sc.nextLine();
				/*
				 * compares two string 
				 * returns 1 if equal, else 0
				 */
				System.out.println(compare(FirstString, SecondString));
				break;
				
			case 2:
				System.out.print("Enter any string -");
				FirstString = sc.nextLine();
				System.out.println(reverse(FirstString));
				break;
				
			case 3:
				System.out.print("Enter any string -");
				FirstString = sc.nextLine();
				/*
				 * caseInversion changes upper to lowercase and vice versa
				 */
				System.out.println(caseInversion(FirstString));
				break;
				
			case 4:
				System.out.print("Enter any string -");
				FirstString = sc.nextLine();
				System.out.println(largestWord(FirstString));
				break;
				
			default:
				System.out.println("Invalid choice... please try again");
				break;
			}
		} while (choice1 != 0);
	}
}
