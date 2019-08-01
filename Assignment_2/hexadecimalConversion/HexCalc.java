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
	private String FirstNumber;
	private String SecondNumber;
	private String DIGITS ="0123456789ABCDEF";
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * this is a getDecimal method for the conversion of HexaDecimal no. to
	 * Decimal no.
	 * 
	 * @param  {String}HexNumber   Hexadecimal no. user input
	 * 
	 * @return {integer}value     Decimal equivalent of Hexadecimal no
	 */
	public int getDecimal(String HexNumber) {
		int index, value = 0;
		char character;
		String temp;

		HexNumber = HexNumber.toUpperCase();
		for (int count = 0; count < HexNumber.length(); count++) {
			character = HexNumber.charAt(count);
			temp = Character.toString(character);
			if (DIGITS.contains(temp)) {
				index = DIGITS.indexOf(character);
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
	 * @param  {String} HexNumber
	 * 
	 * @return {boolean} value 
	 */
	public boolean check(String HexNumber) {
		char character;
		String string;
		
		HexNumber = HexNumber.toUpperCase();
		
		for (int count = 0; count < HexNumber.length(); count++) {
			character = HexNumber.charAt(count);
			string = Character.toString(character);
			if (!DIGITS.contains(string)) {
				System.out.println("Invalid Hexadecimal no");
				return false;
			}
		}
		return true;
	}

	/**
	 * this method is used to check if LENGTH of FirstNumber is Greater than
	 * SecondNumber
	 * 
	 * 
	 * @param {String} FirstNumber
	 * @param {String} SecondNumber
	 * 
	 * @return {boolean}value
	 */
	public boolean isLengthgreater(String FirstNumber, String SecondNumber) {
		if (check(FirstNumber) && check(SecondNumber)) {
			if (FirstNumber.length() > SecondNumber.length()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * this method is used to check if LENGTH of FirstNumber is Smaller than
	 * SecondNumber
	 * 
	 * @param {String} FirstNumber
	 * @param {String} SecondNumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isLengthsmaller(String FirstNumber, String SecondNumber) {
		if (check(FirstNumber) && check(SecondNumber)) {
			if (FirstNumber.length() < SecondNumber.length()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this is isEqual method used to check if String A == String B
	 * 
	 * @param {String} FirstNumber
	 * @param {String} SecondNumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isEqual(String FirstNumber, String SecondNumber) {
		boolean value = true;
		
		//check method is created to check the validity of HexDecimal No
		if (check(FirstNumber) && check(SecondNumber) && FirstNumber.length() == SecondNumber.length()) {
				for (int count = 0; count < FirstNumber.length(); count++) {
					if (FirstNumber.charAt(count) != SecondNumber.charAt(count)) {
						value = false;
						break;
					}
				}
			}
		return value;
	}

	/**
	 * this isGreater method is used to check is FirstNumber > SecondNumber or
	 * not
	 * 
	 * @param {String} FirstNumber
	 * @param {String} SecondNumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isGreater(String FirstNumber, String SecondNumber) {
		boolean value = true;
		if (check(FirstNumber) && check(SecondNumber)) {
			if (FirstNumber.length() == SecondNumber.length()) {
				for (int count = 0; count < FirstNumber.length(); count++) {
					if (FirstNumber.charAt(count) < SecondNumber.charAt(count)) {
						value = false;
						break;
					}else if (FirstNumber.charAt(count) > SecondNumber.charAt(count)) {
						value = true;
					}
				}
			}else if (isLengthgreater(FirstNumber, SecondNumber)) {
				value = true;
			}
		}
		return value;
	}

	/**
	 * 
	 * isSmaller method is used to check if FirstNumber < SecondNumber or not .
	 * 
	 * @param {String} FirstNumber
	 * @param {String} SecondNumber
	 * 
	 * @return {boolean} value
	 */
	public boolean isSmaller(String FirstNumber, String SecondNumber) {
		boolean value = false;
		
		if (check(FirstNumber) && check(SecondNumber) && (FirstNumber.length() == SecondNumber.length())){
			for (int count = 0; count < FirstNumber.length(); count++) {
					if (FirstNumber.charAt(count) > SecondNumber.charAt(count)) {
						value = false;
						break;
					} else if (FirstNumber.charAt(count) < SecondNumber
							.charAt(count)) {
						value = true;
					}
				}
			}
		else if (isLengthsmaller(FirstNumber, SecondNumber)) {
				value = true;
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
		
		final char digit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
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
	 * addition method is used here to add two HEXADECIMAL NOS.
	 * 
	 * @return {String}addition value of two hexadecimal nos.
	 */
	public String addition() {
		int first, second;

		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		FirstNumber = sc.nextLine();
		System.out.print("second no - ");
		SecondNumber = sc.nextLine();
		first = getDecimal(FirstNumber);
		second = getDecimal(SecondNumber);
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
		FirstNumber = sc.nextLine();
		System.out.print("second no - ");
		SecondNumber = sc.nextLine();
		first = getDecimal(FirstNumber);
		second = getDecimal(SecondNumber);
		return getHex(Math.abs(first - second));
	}

	/**
	 * Multiplication method is used here to Multiply two HEXADECIMAL NOS.
	 * inputs are user inputs FirstNumber and SecondNumber are both Integer type
	 * .
	 * 
	 * @return {String} multiplicated value of two hexadecimal nos.
	 */
	public String multiplication() {
		int first, second;

		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		FirstNumber = sc.nextLine();
		System.out.print("second no - ");
		SecondNumber = sc.nextLine();
		first = getDecimal(FirstNumber);
		second = getDecimal(SecondNumber);
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
		FirstNumber = sc.nextLine();
		check(FirstNumber);
		System.out.print("second no - ");
		SecondNumber = sc.nextLine();
		check(SecondNumber);
		if (check(FirstNumber) && check(SecondNumber)) {
			int first = getDecimal(FirstNumber);
			int second = getDecimal(SecondNumber);
			if (first > second) {
				String value = getHex(first / second);
				//quotient is also printed when division method is called along with remainder.
				System.out.println("quotient = " + value);
				return getHex(first % second);
			} else {
				String value = getHex(second / first);
				
				//quotient is also printed when division method is called along with remainder .
				System.out.println("quotient = " + value);
				return getHex(second % first);
			}
		} else {
			System.out.println("Please Try Again");
		}
		return null;
	}
}