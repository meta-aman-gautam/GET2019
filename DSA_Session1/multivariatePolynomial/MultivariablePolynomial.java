package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a multi-variable polynomial using nested lists with
 * 
 *@author Aman Gautam
 */
public class MultivariablePolynomial {

	List<Term> multivariablePolynomial = new ArrayList<>();

	public MultivariablePolynomial(List<Term> termList) {

		this.multivariablePolynomial = termList;
	}

	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * 
	 * @return degree of the multivariable polynomial
	 */
	int degree() {
		int powerSum;
		int degreePolynomial = 0;
		for (Term term : multivariablePolynomial) {
			powerSum = 0;
			for (Variable variable : term.variableList) {
				powerSum += variable.getVariablePower();
			}
			if (degreePolynomial < powerSum)
				degreePolynomial = powerSum;
		}
		return degreePolynomial;
	}

	/**
	 * This method visualises the Multivariable polynomial into string
	 * 
	 * @return Multivariable Polynomial
	 */
	String printPolynomial() {
		String polynomialString = "";
		for (Term term : multivariablePolynomial) {
			polynomialString = polynomialString + term.termCoefficient;
			for (Variable variable : term.variableList) {
				polynomialString = polynomialString + "*"
						+ variable.getVaribleName() + "^"
						+ variable.getVariablePower();
			}
			if (term != multivariablePolynomial.get(multivariablePolynomial.size() - 1))
				polynomialString = polynomialString + " + ";
		}
		return polynomialString;
	}

}