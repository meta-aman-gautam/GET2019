package charaterSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;
/**
 * String Counting class is created to calculate the unique character in a string .
 *
 * @author Aman Gautam
 * Dated- 11/8/2019
 *
 */
public class StringCounting {
	
	Map<String,Integer> map = new HashMap<String,Integer>(); 
	Set<String> set  ;
	
	/**
	 * calculation method stores the unique character to inside the map no of unique charactesrs.
	 * 
	 * 
	 * @param inputString
	 * @return no of unique character
	 */
	public int calculation(String inputString){
		set = new HashSet<String>(); 
		int answer=0;  
		
		try {
			if(inputString ==null) {
				throw new InputMismatchException("Wrong Input");
			}
			else if(inputString ==" ") {
				throw new InputMismatchException("Input cannot be empty");
			}
			
			if(cache(inputString)!=-1) {
				answer= cache(inputString);
			}
			else {
				for(int count_i=0;count_i<inputString.length();count_i++){
					if(!" ".equals(Character.toString(inputString.charAt(count_i)))){
						set.add(Character.toString(inputString.charAt(count_i))); 
					}
				}
				answer = set.size();
				map.put(inputString, answer);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return answer;
	}
	
	/**
	 *  this method verifies that if the string is already present in the 
	 *  cache memory .
	 *  
	 * @param inputString
	 * @return cacheValue
	 */
	public int cache(String inputString){
		int cacheValue= -1;
		if(map.containsKey(inputString)){
			cacheValue= map.get(inputString);
		}
		
		return cacheValue;
	}
	

}

