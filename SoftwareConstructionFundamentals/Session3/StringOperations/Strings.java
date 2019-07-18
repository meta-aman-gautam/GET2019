package StringOperations;

import java.util.*;

public class Strings {

	/**
	 * This method compares two string [if equal then returns 1 else 0]
	 * 
	 * @param {String}firststring
	 * @param {String}secondstring
	 * 
	 * @return boolean value
	 */
	public static int compare(String firststring, String secondstring) {
		int count = 0;
		String greater;
		
		if (firststring.length() != secondstring.length()) {
			return 0;
		} else {
			if (firststring.length() > secondstring.length())
				greater = firststring;
			else {
				greater = secondstring;
				secondstring = firststring;
			}
			for (int index = 0; index < greater.length(); index++) {
				if (greater.charAt(index) != secondstring.charAt(index)) {
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
	 * @param {string}firststring   - input string at run time
	 * 
	 * @return {string}secondstring   -reversed string
	 */
	public static String reverse(String firststring) {
		String secondstring = "";
		for (int count = 0; count < firststring.length(); count++) {
			if (firststring.charAt(count) == ' ') {
				secondstring = ' ' + secondstring;
			} else {
				secondstring = firststring.charAt(count) + secondstring;
			}
		}
		return secondstring;
	}

	
	/**
	 * this method replaces lowercase characters with uppercase and vice-versa
	 * in the string.
	 * 
	 * @param {string}firststring  -  input string at run time
	 *            
	 * @return {string}secondstring - Uppercase character switch with lowercase and vice verse
	 */
	public static String caseInversion(String firststring) {
		String secondstring = "";
		for (int count = 0; count < firststring.length(); count++) {
			if (firststring.charAt(count) >= 65 && firststring.charAt(count) <= 91) {
				secondstring = secondstring
						+ (char) (firststring.charAt(count) + 32);
			} else if (firststring.charAt(count) >= 97
					&& firststring.charAt(count) <= 122) {
				secondstring = secondstring
						+ (char) (firststring.charAt(count) - 32);
			} else if (firststring.charAt(count) == ' ') {
				secondstring = secondstring + ' ';
			}
		}
		return secondstring;
	}

	
	
	/**
	 * this method returns the largest word of a string , if last two word have
	 * same length then it return the last word.
	 * 
	 * @param {string}firststring
	 *           
	 * @return {string} greatest  - largest word of the string is the output
	 */
	public static String largestWord(String firststring) {
		String secondstring = "";
		String greatest = "";

		for (int count = 0; count < firststring.length(); count++) {
			if (firststring.charAt(count) == ' ') {
				if (greatest.length() <= secondstring.length()) {
					greatest = secondstring;
					secondstring = "";
				} else {
					secondstring = "";
				}
			}
			else {
				secondstring += firststring.charAt(count);
			}
		}
		if (greatest.length() <= secondstring.length()) {
			greatest = secondstring;
			secondstring = "";
		}
		return greatest;
	}

	
	
	/**
	 * MAIN METHOD 
	 * @param args
	 */
	public static void main(String[] args) {

		int choice1;
		String firststring, secondstring;

		Scanner sc = new Scanner(System.in);

		do {
			System.out
					.println("\nENTER YOUR CHOICE :\n"
							+ "1- Compare two strings.\n"
							+ "2- Return the reverse of any string\n"
							+ "3- Replace lowercase characters with uppercase and vice-versa in a String\n"
							+ "4- Return the largest word of a string");

			choice1 = sc.nextInt();
			
			//BUG in java *** this input is useless .
			firststring = sc.nextLine();

			switch (choice1) {

			case 1:
				System.out.print("Enter the first string -");
				firststring = sc.nextLine();
				System.out.print("Enter the second string -");
				secondstring = sc.nextLine();
				
				/*
				 * compares two string 
				 * returns 1 if equal, else 0
				 */
				System.out.println(compare(firststring, secondstring));

				break;
			case 2:
				System.out.print("Enter any string -");
				firststring = sc.nextLine();
				System.out.println(reverse(firststring));

				break;
			case 3:
				System.out.print("Enter any string -");
				firststring = sc.nextLine();
				/*
				 * caseInversion changes upper to lowercase and vice versa
				 */
				System.out.println(caseInversion(firststring));

				break;
			case 4:
				System.out.print("Enter any string -");
				firststring = sc.nextLine();
				System.out.println(largestWord(firststring));

				break;
			default:
				System.out.println("Invalid choice... please try again");

				break;

			}

		} while (choice1 != 0);

	}

}
