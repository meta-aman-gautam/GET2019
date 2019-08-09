package dictionary;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for DictionarayImp test.
 * 
 * @author Aman Gautam
 * 
 * Dated - 08/08/2019
 */
public class DictionaryImplementationTest {
	
	DictionaryImplementation bst ;
	JsonInput jsonRead;
	
	@Before
	public void initialize(){
		bst = new DictionaryImplementation();
		jsonRead = new JsonInput();
		bst.root = jsonRead.Json("C:\\AMAN\\GET\\PF\\ASSIGNMENT2019\\DS_Session5\\KeyValue.json.txt");
	}
	
	@Test
	public void testFor_getSortedList(){
		bst.getSortedList(bst.root);
		assertEquals(1, bst.list.get(0).key);
		assertEquals(2, bst.list.get(1).key);
		assertEquals(3, bst.list.get(2).key);
	}
	
	@Test
	public void testFor_getSortedListRange(){
		bst.getSortedListRange(bst.root , 3,5);
		assertEquals(3, bst.listRange.get(0).key);
		assertEquals(4, bst.listRange.get(1).key);
		assertEquals(5, bst.listRange.get(2).key);
	}
	
	@Test
	public void testFor_getKeyValue(){
		assertEquals("3", bst.getKeyValue(3));
		assertEquals("4", bst.getKeyValue(4));
		assertEquals("5", bst.getKeyValue(5));
		assertEquals("6", bst.getKeyValue(6));
	}
}