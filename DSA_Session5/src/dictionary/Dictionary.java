package dictionary;
import java.util.*;

/**
 * interface dictionary for DictionaryImp class . 
 * 
 * @author Aman Gautam
 * 
 * Date - 06/08/2019
 */
public interface Dictionary {

	public boolean addKeyValue(String key, String value);
	
	public boolean deleteKeyValue(String key);
	
	public String getValue(String key);
	
	public List<Value> getAllKeys();
	
	public List<Value> getBetweenTwoKeys(String key1,String key2);
}
