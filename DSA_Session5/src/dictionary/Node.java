package dictionary;

/**
 * Node class 
 * 
 * @author Aman Gautam
 * 
 * Dated 8/8/2019
 *
 */
public class Node {

	public KeyValuePair data ;
	
	Node leftChild,rightChild;

	/**
	 * Instantiates a new node.
	 *
	 * @param data
	 */
	public Node(KeyValuePair data){
		this.data = data;
		leftChild=rightChild=null;
	}
}
