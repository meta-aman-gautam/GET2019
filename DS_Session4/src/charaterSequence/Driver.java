package charaterSequence;

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
