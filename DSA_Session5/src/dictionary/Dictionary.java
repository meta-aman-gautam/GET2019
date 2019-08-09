package dictionary;

/**
 * interface dictionary for DictionaryImp class . 
 * 
 * @author Aman Gautam
 * 
 * Date - 08/08/2019
 */
public interface Dictionary {

	public void insertKey(KeyValuePair data);

	public Node deleteKey(int data);

	public String getKeyValue(int data);

	public void getSortedList(Node root);

	public void getSortedListRange(Node root, int key1, int key2);
	
	public void inOrderTraversal(Node root);
	
}
