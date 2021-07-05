package multivariatePolynomial;


/**
 * This class represents a single variable along with its power in a
 * multivariable polynomial
 * 
 * @ author Aman Gautam
 */
public class Variable {

	private char varibleName;
	int power;

	/**
	 * Constructor to initialize the data members of the class
	 * 
	 * @param variableName is the variable name(x or y or z or etc.)
	 * @param variablePower is the variable power
	 */
	Variable(char variableName, int variablePower) {
		this.power = variablePower;
		this.varibleName = variableName;
	}

	/**
	 * This method returns the name of the variable
	 * 
	 * @return name of the variable
	 */
	public char getVaribleName() {
		return varibleName;
	}

	/**
	 * This method returns the power of the variable
	 * 
	 * @return power of the variable
	 */
	public int getVariablePower() {
		return power;
	}

}