/**
 * 
 */
package question1;

/**
 * @author Aman
 *
 */
import java.util.Scanner;

/**
 * @author Aman this the public class which is heavily used in the main class
 *         HexCalc
 */
public class Hex_to_decimal {
	private String A;
	private String B;
	Scanner sc = new Scanner(System.in);

	/**
	 * this is a getDecimal method for the conversion of HexaDecimal no. to Decimal
	 * no.
	 * 
	 * @param hex String type
	 * @return value integer type Decimal equivalent
	 */
	public int getDecimal(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int value = 0;
		for (int i = 0; i < hex.length(); i++) {
			char ch = hex.charAt(i);
			String s = Character.toString(ch);
			if (digits.contains(s)) {
				int d = digits.indexOf(ch);
				value = 16 * value + d;

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
	 * @param hex string type
	 * @return value boolean type
	 */
	public boolean check(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();

		for (int i = 0; i < hex.length(); i++) {
			char ch = hex.charAt(i);
			String s = Character.toString(ch);
			if (!digits.contains(s)) {
				System.out.println("Invalid Hexadecimal no");
				return false;
			}

		}
		return true;

	}

	/**
	 * this method is used to check if LENGTH of String A is Greater than String B
	 * 
	 * @param A string type
	 * @param B string type
	 * @return value boolean type
	 */
	public boolean isLengthgreater(String A, String B) {
		if (check(A) && check(B)) {
			if (A.length() > B.length()) {
				return true;

			}
		}
		return false;
	}

	/**
	 * this method is used to check if LENGTH of String A is Smaller than String B
	 * 
	 * @param A string type
	 * @param B string type
	 * @return value boolean type
	 */
	public boolean isLengthsmaller(String A, String B) {
		if (check(A) && check(B)) {
			if (A.length() < B.length()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * this is isEqual method used to check if String A == String B
	 * 
	 * @param A string type
	 * @param B string type
	 * @return value boolean type
	 */
	public boolean isEqual(String A, String B) {
		boolean value = false;
		if (check(A) && check(B)) {

			int count = 0;
			if (A.length() == B.length()) {

				for (int i = 0; i < A.length(); i++) {

					if (A.charAt(i) != B.charAt(i)) {
						value = false;
						break;
					} else {
						if (count == A.length() - 1) {
							value = true;
							break;
						}
						count++;
					}

				}
			}

		}
		return value;
	}

	/**
	 * this isGreater method is used to check is String A > String B or not
	 * 
	 * @param A string type
	 * @param B string type
	 * @return value boolean type
	 */
	public boolean isGreater(String A, String B) {
		boolean value = false;
		if (check(A) && check(B)) {

			if (A.length() == B.length()) {

				for (int i = 0; i < A.length(); i++) {

					if (A.charAt(i) < B.charAt(i)) {
						value = false;
						break;
					} else if (A.charAt(i) > B.charAt(i)) {
						value = true;
					}

				}
			} else if (isLengthgreater(A, B)) {
				value = true;
			}

		}

		return value;
	}

	/**
	 * 
	 * this isSmaller method is used to check is String A < String B or not
	 * 
	 * @param A string type
	 * @param B string type
	 * @return value boolean type
	 */
	public boolean isSmaller(String A, String B) {
		boolean value = false;
		if (check(A) && check(B)) {

			if (A.length() == B.length()) {

				for (int i = 0; i < A.length(); i++) {

					if (A.charAt(i) > B.charAt(i)) {
						value = false;
						break;
					} else if (A.charAt(i) < B.charAt(i)) {
						value = true;
					}

				}
			} else if (isLengthsmaller(A, B)) {
				value = true;
			}

		}

		return value;
	}

	/**
	 * getHex is a method created to convert DECIMAL NO. to HEXADECIMAL NO.
	 * 
	 * @param deci integer type
	 * @return value String type
	 */
	public String getHex(int deci) {
		char digit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int remainder;
		String value = "";
		do {
			remainder = deci % 16;
			value = digit[remainder] + value;
			deci = deci / 16; // quotient is replaced with deci

		} while (deci != 0);
		return value;

	}

	/**
	 * addition method is used here to add to HEXADECIMAL NOS. inputs are user
	 * inputs A and B both Integer type .
	 * 
	 * @return string type Hexadecimal equivalent
	 */
	public String addition() {
		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		A = sc.nextLine();
		System.out.print("second no - ");
		B = sc.nextLine();
		int first = getDecimal(A);
		int second = getDecimal(B);
		return getHex(first + second);

	}

	/**
	 * Subtraction method is used here to subtract to HEXADECIMAL NOS. inputs are
	 * user inputs A and B both Integer type .
	 * 
	 * @return string type, hexadecimal equivalent
	 */
	public String subtraction() {
		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		A = sc.nextLine();
		System.out.print("second no - ");
		B = sc.nextLine();
		int first = getDecimal(A);
		int second = getDecimal(B);
		return getHex(Math.abs(first - second));
	}

	/**
	 * Multiplication method is used here to Multiply two HEXADECIMAL NOS. inputs
	 * are user inputs A and B both Integer type .
	 * 
	 * @return string type, hexadecimal equivalent
	 */
	public String multiplication() {
		System.out.println("Enter two hexadecimal nos.");
		System.out.print("first no -");
		A = sc.nextLine();
		System.out.print("second no - ");
		B = sc.nextLine();
		int first = getDecimal(A);
		int second = getDecimal(B);
		return getHex(first * second);
	}

	/**
	 * division method is used here to Divide two HEXADECIMAL NOS. inputs are user
	 * inputs A and B both Integer type .
	 * 
	 * @return string type, hexadecimal equivalent
	 */
	public String division() {
		System.out.println("Enter two hexadecimal nos.");

		System.out.print("first no -");
		A = sc.nextLine();
		check(A);
		System.out.print("second no - ");
		B = sc.nextLine();
		check(B);
		if (check(A) && check(B)) {
			int first = getDecimal(A);
			int second = getDecimal(B);
			if (first > second) {
				String value = getHex(first / second);
				System.out.println("quotient = " + value);
				return getHex(first % second);

			} else {
				String value = getHex(second / first);
				System.out.println("quotient = " + value);
				return getHex(second % first);
			}

		} else {
			System.out.println("Please Try Again");
		}
		return null;

	}

}
