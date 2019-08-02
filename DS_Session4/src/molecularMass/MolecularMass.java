package molecularMass;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MolecularMass {
	
	Stack<String> moleculeStack = new Stack<>();
	Driver d =new Driver() ;
	
	int mass=0;
	String inputString ;

	
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public MolecularMass() {
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put(")", 0);
	}
		

	
	public int dummy(int position){
		String dummy ="";
		
		while(!")".equals(inputString.charAt(position))){
			dummy = dummy+inputString.charAt(position);
			position++;
		}
		return Integer.parseInt(dummy);
	}
	
	
	public int evaluate(String inputString){
		int temp=1;
		for(int count_i =inputString.length()-1 ; count_i >=0;count_i--){
			
			//String s =String.valueOf(inputString.charAt(count_i));
			//System.out.println(map.get(String.valueOf(inputString.charAt(count_i))));
			
			//is CHAR
			
				
			if(!Character.isDigit(inputString.charAt(count_i)))
			{
				temp=
			}
			
			else if(Character.isDigit(inputString.charAt(count_i))){
				temp=dummy(count_i);
			}
			else if("(".matches(String.valueOf(inputString.charAt(count_i)))){
				temp=1;
				count_i--;
				
			}
			else if(")".equals(String.valueOf(inputString.charAt(count_i)))){
				count_i--;
				
			}
			mass = mass + map.get(String.valueOf(inputString.charAt(count_i)))*temp;
			
			
		}
		System.out.println("mass-> "+mass);
		return mass;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
