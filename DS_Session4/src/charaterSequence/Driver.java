package charaterSequence;
/**
 *This is Main Class for charaterSequence
 *
 *@Aman Gautam
 *Dated - 3/08/2019
 */
public class Driver {

	public static void main(String[] args) {
		
		StringCounting SC = new StringCounting();
		System.out.println(SC.check("AMAN GAUTAM"));
		System.out.println(SC.check("AMAN KUMAR GAUTAM"));
		System.out.println(SC.check("AMAN GAUTAM"));
		System.out.println(SC.check("GAUTAM"));
		System.out.println(SC.check("AMAN"));
		System.out.println(SC.check("AMAN GAUTAM"));
		System.out.println(SC.check("AMAN"));
	}	
}
