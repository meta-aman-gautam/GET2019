package charaterSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringCounting {
	
	Map<String,Integer> map = new HashMap<String,Integer>(); 
	Set<String> set  ;
	
	
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
	
	public int check(String inString){
		if(cache(inString)!=-1){
			return cache(inString);
		}
		else{
			map.put(inString, calculation(inString));
			return 0;
		}
	}
}

























