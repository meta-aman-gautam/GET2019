package charaterSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * String Counting class is created to calculate the unique character in a string .
 *
 * @author Aman Gautam
 * Dated- 3/8/2019
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
		for(int count_i=0;count_i<inputString.length();count_i++){
			if(!" ".equals(Character.toString(inputString.charAt(count_i)))){
				set.add(Character.toString(inputString.charAt(count_i))); 
			}
		}
		answer = set.size();
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
		int cacheValue= 0;
		cacheValue=calculation(inputString);
		if(map.containsKey(inputString)){
			cacheValue= map.get(inputString);;
		}
		else if(!map.containsKey(inputString)){
			cacheValue= -1;
		}
		return cacheValue;
	}
	
	/**
	 * Check method checks the validation 
	 * @param inString
	 * @return 
	 */
	public int check(String inString){
		assert(inString)!=null: "Input Invalid" ;
		
		if(cache(inString)!=-1){
			return cache(inString);
		}
		else{
			map.put(inString, calculation(inString));
			return 0;
		}
	}
}

