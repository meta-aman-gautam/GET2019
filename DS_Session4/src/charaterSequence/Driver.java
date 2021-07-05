package charaterSequence;

/**
 * The Class Driver.
 */
public class Driver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		StringCounting SC = new StringCounting();
		System.out.println(SC.calculation(null));
		System.out.println(SC.calculation("AMANa KUMAR GAUTAM"));
		System.out.println(SC.calculation(""));
		System.out.println(SC.calculation("GAUTAM"));
		System.out.println(SC.calculation("AMAN"));
		System.out.println(SC.calculation("AMAN GAUTAM"));
		System.out.println(SC.calculation("AMAN"));
	}
}
