package hexadecimalConversion;

import java.util.Scanner;

/**
 * HexCalc is a public class which is heavily used in the main class HexCalc_Driver .
 * 
 * @author Aman Gautam
 * 
 * dated 15/07/2019
 * 
 */
public class HexCalc {
	private String firstnumber;
	private String secondnumber;
	
	
	Scanner sc = new Scanner(System.in);

	
	/**
	 * this is a getDecimal method for the conversion of HexaDecimal no. to
	 * Decimal no.
	 * 
	 * @param  {String}hexnumber   Hexadecimal no. user input
	 * 
	 * @return {integer}value     Decimal equivalent of Hexadecimal no
	 */
	public int getDecimal(String hexnumber) {
		int index, value = 0;
		char character;
		String digits = "0123456789ABCDEF", string;

		hexnumber = hexnumber.toUpperCase();
		for (int i = 0; i < hexnumber.length(); i++) {
			character = hexnumber.charAt(i);
			string = Character.toString(character);
			if (digits.contains(string)) {
				index = digits.indexOf(character);
				value = 16 * value + index;

			} else {
				System.out.println("Invalid Hexadecimal no.");
				value = 0;
				break;
			}
		}
		return value;

	}

	
	/**
	 * this is check method for checking if hexadecimal no. is valid or invalid
	 * 
	 * @param  {String} hexnumber
	 * 
	 * @return {boolean} value 
	 */
	public boolean check(String hexnumber) {
		char character;
		String string;
		String digits = "0123456789ABCDEF";
		
		hexnumber = hexnumber.toUpperCase();

		for (int count = 0; count < hexnumber.length(); count++) {
			character = hexnumber.charAt(count);
			string = Character.toString(character);
			if (!digits.contains(string)) {
				System.out.println("Invalid Hexadecimal no");
				return false;
			}

		}
		return true;

	}

	
	/**
	 * this method is used to check if LENGTH of (first number) is Greater than (second number) 
	 * 
	 * @param {String} firstnumber
	 * @param {String} secondnumber
	 * 
	 * @return {boolean}value
	 */
	public boolean isLengthgreater(String firstnumber, String secondnumber) {
		if (check(firstnumber) && check(secondnumber)) {
			if (firstnumber.length() > secondnumber.length()) {
				return true;

			}
		}
		return false;
	}

	
	/**
	 * this method is used to check if LENGTH of firstnumber is Smaller than
	 * secondnumber
	 * 
	 * @param {String} firstnumber
	 * @param {String} secondnumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isLengthsmaller(String firstnumber, String secondnumber) {
		if (check(firstnumber) && check(secondnumber)) {
			if (firstnumber.length() < secondnumber.length()) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * this is isEqual method used to check if firstnumber == secondnumber
	 * 
	 * @param {String} firstnumber
	 * @param {String} secondnumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isEqual(String firstnumber, String secondnumber) {
		boolean value = false;

		if (check(firstnumber) && check(secondnumber)) {
			int flag = 0;
			if (firstnumber.length() == secondnumber.length()) {

				for (int count = 0; count < firstnumber.length(); count++) {

					if (firstnumber.charAt(count) != secondnumber.charAt(count)) {
						value = false;
						break;
					} else {
						if (flag == firstnumber.length() - 1) {
							value = true;
							break;
						}
						flag++;
					}

				}
			}

		}
		return value;
	}

	
	/**
	 * this isGreater method is used to check is firstnumber > secondnumber or
	 * not
	 * 
	 * @param {String} firstnumber
	 * @param {String} secondnumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isGreater(String firstnumber, String secondnumber) {
		boolean value = false;
		
		if (check(firstnumber) && check(secondnumber)) {

			if (firstnumber.length() == secondnumber.length()) {

				for (int count = 0; count < firstnumber.length(); count++) {

					if (firstnumber.charAt(count) < secondnumber.charAt(count)) {
						value = false;
						break;
					} else if (firstnumber.charAt(count) > secondnumber
							.charAt(count)) {
						value = true;
					}

				}
			} else if (isLengthgreater(firstnumber, secondnumber)) {
				value = true;
			}

		}
		return value;
	}

	
	/**
	 * 
	 * isSmaller method is used to check if firstnumber < secondnumber or not .
	 * 
	 * @param {String} firstnumber
	 * @param {String} secondnumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isSmaller(String firstnumber, String secondnumber) {
		boolean value = false;
		
		if (check(firstnumber) && check(secondnumber)) {

			if (firstnumber.length() == secondnumber.length()) {

				for (int count = 0; count < firstnumber.length(); count++) {

					if (firstnumber.charAt(count) > secondnumber.charAt(count)) {
						value = false;
						break;
					} else if (firstnumber.charAt(count) < secondnumber
							.charAt(count)) {
						value = true;
					}

				}
			} else if (isLengthsmaller(firstnumber, secondnumber)) {
				value = true;
			}

		}

		return value;
	}

	
	/**
	 * getHex is a method created to convert DECIMAL NO. to HEXADECIMAL NO.
	 * 
	 * @param {integer} decimalnumber
	 * 
	 * @return {String} value
	 */
	public String getHex(int decimalnumber) {
		int remainder;
		String value = "";
		
		char digit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		
		
		do {
			remainder = decimalnumber % 16;
			value = digit[remainder] + value;
			// quotient is replaced with decimal
			decimalnumber = decimalnumber / 16;

		} while (decimalnumber != 0);
		return value;

	}

	
	/**
	 * addition method is used here to add to HEXADECIMAL NOS.
	 * 
	 * @return {String} addition value of two hexadecimal nos.
	 */
	public String addition() {
		int first, second;

		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		firstnumber = sc.nextLine();
		System.out.print("second no - ");
		secondnumber = sc.nextLine();
		first = getDecimal(firstnumber);
		second = getDecimal(secondnumber);
		return getHex(first + second);

	}

	
	/**
	 * Subtraction method is used here to subtract two HEXADECIMAL NOS.
	 * 
	 * @return {String} subtracted value value of two hexadecimal nos.
	 */
	public String subtraction() {
		int first, second;

		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		firstnumber = sc.nextLine();
		System.out.print("second no - ");
		secondnumber = sc.nextLine();
		first = getDecimal(firstnumber);
		second = getDecimal(secondnumber);
		return getHex(Math.abs(first - second));
	}

	/**
	 * Multiplication method is used here to Multiply two HEXADECIMAL NOS.
	 * inputs are user inputs firstnumber and secondnumber are both Integer type
	 * .
	 * 
	 * @return {String} multiplicated value of two hexadecimal nos.
	 */
	public String multiplication() {
		int first, second;

		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		firstnumber = sc.nextLine();
		System.out.print("second no - ");
		secondnumber = sc.nextLine();
		first = getDecimal(firstnumber);
		second = getDecimal(secondnumber);
		return getHex(first * second);
	}

	
	/**
	 * division method is used here to Divide two HEXADECIMAL NOS. inputs are
	 * user inputs A and B both Integer type .
	 * 
	 * @return {String} remainder 
	 */
	public String division() {
		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		firstnumber = sc.nextLine();
		check(firstnumber);
		System.out.print("second no - ");
		secondnumber = sc.nextLine();
		check(secondnumber);
		if (check(firstnumber) && check(secondnumber)) {
			int first = getDecimal(firstnumber);
			int second = getDecimal(secondnumber);
			if (first > second) {
				String value = getHex(first / second);
				/*
				 * quotient is also printed when division method is called along with remainder.
				 */
				System.out.println("quotient = " + value);
				return getHex(first % second);

			} else {
				String value = getHex(second / first);
				/*
				 * quotient is also printed when division method is called along with remainder .
				 */
				System.out.println("quotient = " + value);
				return getHex(second % first);
			}

		} else {
			System.out.println("Please Try Again");
		}
		return null;

	}

}