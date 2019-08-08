package dictionary;


import static org.junit.Assert.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

/**
 * Test class for DictionarayImp test.
 * 
 * @author Aman Gautam
 * 
 * Dated - 06/08/2019
 */
public class DictionaryImpTest {
	@Test
	public void addSuccessTest(){
		
		String value = new String();
		try{
			FileReader file = new FileReader("C:/AMAN/GET/PF/ASSIGNMENT2019/DS_Session5/src/dictionary/input.json.txt");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementation(json);
			value = dictionary.getValue("20");
			assertEquals(value, "twenty");
			value = dictionary.getValue("40");
			assertEquals(value, "fourty");
			value = dictionary.getValue("50");
			assertEquals(value, "fifty");
		}
		catch(Exception e){
			System.out.println("File not found");
		}
	}

	/**
	 * delete key and value success case
	 * @throws Exception
	 */
	@Test
	public void deleteSuccessTest() {

		try{
			FileReader file = new FileReader("C:/AMAN/GET/PF/ASSIGNMENT2019/DS_Session5/src/dictionary/input.json.txt");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			DictionaryImplementation dictionary = new DictionaryImplementation(json);

			List<Value> expected = new ArrayList<Value>();
			expected.add(new Value("20", "twenty"));
			expected.add(new Value("40", "fourty"));
			expected.add(new Value("50", "fifty"));
			boolean result = dictionary.deleteKeyValue("20");
			assertTrue(result);
		}
		catch(Exception e){
			System.out.println("File not Found");
		}
	}

	/**
	 * method to check null value case for adding
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void nullValueTest() throws Exception {
		Dictionary dictionary = new DictionaryImplementation();
		dictionary.addKeyValue(null, "value");
	}

	/**
	 * method to check null key case for adding
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void nullKeyTest() throws Exception {
		Dictionary dictionary = new DictionaryImplementation();
		dictionary.addKeyValue("key", null);
	}
}
