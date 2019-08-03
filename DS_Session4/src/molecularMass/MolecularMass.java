package molecularMass;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * this is MolecularMass class which is calculate the Mass of Molecular Compounds
 * 
 * @author Aman Gautam
 * Dated - 3/8/2019
 */
public class MolecularMass {
	
	int mass=0,submass=0;
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	Stack<Integer> massStack = new Stack<>();
	Stack<Integer> tempStack = new Stack<>();

	public MolecularMass() {
		map.put("C", 12);
		map.put("O", 16);
		map.put("H", 1);
	}
	/*
	 * dummy is used to capture the Integer value after brackets 
	 */
	public int dummy(int position,String inputString){
		String dummy ="";
		
		while(Character.isDigit(inputString.charAt(position+1))){
			dummy = dummy+inputString.charAt(position+1);
			try {
				position++;
				dummy(position, inputString);
			}
			catch(Exception e) {
				break;
			}
		}
		return Integer.parseInt(dummy);
	}
	
	/*
	 * alphabetic method is used to capture the Integer value after Alphabets  
	 */
	public int alphabetic(int count_i, String inputString){
		int temp =1;
		try{
			temp=dummy(count_i, inputString)*temp;
		}
		catch(Exception e) {
			try{
				temp =Integer.parseInt(Character.toString(inputString.charAt(count_i+1)));
			}
			catch(Exception f){
				temp=1;
			}
		}
		return temp;
	}
	
	/*
	 * evaluate method is used for the evaluation for molecular compound
	 */
	public int evaluate(String inputString) throws AssertionError{
		assert (inputString) != null:"Input Cannot be Null";
		int temp=1,temp2=1 ;
		for(int count_i =inputString.length()-1 ; count_i >=0;count_i--){
			
			if(Character.isAlphabetic(inputString.charAt(count_i))){
				temp=alphabetic(count_i, inputString);
				mass=map.get(Character.toString(inputString.charAt(count_i)))*temp;
				massStack.push(mass);
			}
			
			else if(")".equals(Character.toString((inputString.charAt(count_i))))){
				temp= alphabetic(count_i, inputString);
				while(!"(".equals(Character.toString((inputString.charAt(count_i))))){
					if(Character.isAlphabetic(inputString.charAt(count_i))){
						temp2=alphabetic(count_i, inputString);
						submass+=map.get(Character.toString(inputString.charAt(count_i)))*temp2;
					}
					count_i--;
					mass=submass ;
				}
				submass=0;
				mass =mass*temp;
				massStack.push(mass);
				temp=1;
			}
		}
		mass=0;
		temp=massStack.size();
		for(int i=0;i<temp;i++ ) {
			mass+=massStack.pop();
		}
		System.out.println("mass of "+inputString+" is "+mass);
		return mass;
	}

}