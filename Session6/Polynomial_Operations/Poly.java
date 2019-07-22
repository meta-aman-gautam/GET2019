package Polynomial_Operations;

import java.util.Arrays;

public class Poly {

	public int[] polynomial;

	/**
	 * Poly() is a constructor of class Poly for initialising input polynimial
	 * 
	 * @param inputPolynomial is input polynomial from user
	 */
	public Poly(int[] inputPolynomial) {
		polynomial = inputPolynomial;
		if (polynomial.length == 0)
			throw new AssertionError("Array empty");
	}

	public Poly() {
		// default constructor for Poly
	}



	/**
	 * evaluate takes in value of variable in polynomial and calculates the
	 * value of the polynomial
	 * 
	 * @param value
	 *            is input value for variable
	 * @return evaluatedValue is the evaluated value of the polynomial
	 */
	public float evaluate(int value) {
		float evaluatedValue = 0;
		for (int count = 0; count < polynomial.length; count++) {
			evaluatedValue += polynomial[count] * (Math.pow(value, count));
		}
		System.out.println("evaluated->"+evaluatedValue);
		return evaluatedValue;
	}

	/**
	 * degree calculates the degree of the polynomial
	 * 
	 * @return length is highest degree of polynomial
	 */
	public int degree() {

		int length = polynomial.length - 1;
		while (polynomial[length] == 0) {
			if (length == 0)
				break;
			length--;
		}
		System.out.println("->"+length);
		return length;
	}

	/**
	 * add accepts two objects of Poly class and returns the sum of two
	 * polynomials
	 * 
	 * @param value1
	 *            is first Polynomial
	 * @param value2
	 *            is second polynomial
	 */
	public String add(Poly value1, Poly value2) {
		int length1 = value1.polynomial.length, length2 = value2.polynomial.length;
		int minLength = Math.min(length1, length2), maxLength = Math.max(length1, length2);
		int sumList[] = new int[maxLength];

		String retString;
		for (int count = 0; count < maxLength; count++) {
			if (count < minLength)
				sumList[count] = value1.polynomial[count]
						+ value2.polynomial[count];
			else {
				if (length1 == maxLength)
					sumList[count] = value1.polynomial[count];
				else
					sumList[count] = value2.polynomial[count];
			}
		}
		retString = Arrays.toString(sumList);
		System.out.println(retString);
		return retString;
	}

	/**
	 * mul accepts two objects of Poly class and returns the multiplication of
	 * two polynomials
	 * 
	 * @param value1
	 *            is first Polynomial
	 * @param value2
	 *            is second polynomial
	 * @return String value of polynomial
	 */
	public String mul(Poly value1, Poly value2) {
		int length1 = value1.polynomial.length;
		int length2 = value2.polynomial.length;
		int mulList[] = new int[length1 + length2 - 1];
		String retString = null;

		for (int count_i = 0; count_i < length1; count_i++) {
			/*
			 * Multiply the current term of first polynomial with every term of
			 * second polynomial.
			 */
			for (int count_j = 0; count_j < length2; count_j++) {
				mulList[count_i + count_j] += value1.polynomial[count_i] * value2.polynomial[count_j];
			}
		}
		retString = Arrays.toString(mulList);

		return retString;
	}

}
