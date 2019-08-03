package molecularMass;
/**
 * this driver class 
 * 
 * @author Aman Gautam
 * dated -3/8/2019
 */
public class Driver {
	
	public static void main(String[] args) {
		
		String inputString = "H2OCO4(CO2)14";
		MolecularMass mass = new MolecularMass();
		mass.evaluate(inputString);
	}
}


