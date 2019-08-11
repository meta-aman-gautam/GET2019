package molecularMass;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * this driver class 
 * 
 * @author Aman Gautam
 * dated -11/8/2019
 */
public class Driver {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Compound :");
		String inputString = sc.nextLine();
		inputString = inputString.toUpperCase();
	
		try {
			if(inputString ==null) {
				throw new InputMismatchException("Wrong Input");
			}
			else if(inputString ==" " || inputString =="") {
				throw new InputMismatchException("Input cannot be empty");
			}
			else {
				for(int count_i=0;count_i<inputString.length();count_i++) {
					if(!(Character.isAlphabetic(inputString.charAt(count_i)) || Character.isDigit(inputString.charAt(count_i)))) {
						throw new IOException("Wrong Input");
					}
				}
			}
			MolecularMass mass = new MolecularMass();
			mass.evaluate(inputString);
			main(args);
		}
		catch(Exception e) {
			System.out.println(e);
			main(args);
		}
	}
}


