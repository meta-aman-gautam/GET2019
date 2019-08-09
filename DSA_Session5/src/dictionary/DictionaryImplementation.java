package dictionary;

import java.util.ArrayList;

/**
 * The Class DictionaryImplementation.
 * @author Aman Gautam
 * 
 * Date - 08/08/2019
 */
public class DictionaryImplementation implements Dictionary {
	
	Node root;
	ArrayList<KeyValuePair> listRange;
	ArrayList<KeyValuePair> list;

	/**
	 * Instantiates a new dictionary implementation.
	 */
	public DictionaryImplementation() {
		root =null;
		list = new ArrayList<KeyValuePair>();
		listRange = new ArrayList<KeyValuePair>();
	}
	
	/**
	 * Method Insert Key
	 * @param {KeyValuePair} data
	 */
	@Override
	public void insertKey(KeyValuePair data){
		root = insertKeyRecursively(root,data);
	}
	
	/**
	 * Insert key recursively.
	 *
	 * @param {Node}root 
	 * @param {KeyValuePair}data 
	 * @return {Node}
	 */
	private Node insertKeyRecursively(Node root,KeyValuePair data){
		if(root==null){
			root = new Node(data);
		}
		else if(data.key <root.data.key){
			root.leftChild = insertKeyRecursively(root.leftChild, data);
		}
		else if(data.key>root.data.key){
			root.rightChild = insertKeyRecursively(root.rightChild, data);
		}
		
		return root;
	}
	
	/**
	 * Find minimum of the nodes.
	 *
	 * @param  {Node} root 
	 * @return {Node} root
	 */
	private Node findMinimum(Node root){
		while(root!=null){
			root = root.leftChild;
		}
		
		return root;
	}

	/**
	 * deleteKey method 
	 * @param {Node}
	 */
	@Override
	public Node deleteKey(int data){
		
		root = deleteKeyRecursively(root,data);
		return root;
	}
	
	/**
	 * Delete key recursively.
	 *
	 * @param {Node} root
	 * @param {Integer}data 
	 * @return {Node}
	 */
	private Node deleteKeyRecursively(Node root, int data){
		if(root==null){
			return root;
		}
		else if(data <root.data.key){
			root.leftChild = deleteKeyRecursively(root.leftChild, data);
		}
		else if(data>root.data.key){
			root.rightChild = deleteKeyRecursively(root.rightChild, data);
		}
		else{
			if(root.leftChild==null && root.rightChild ==null){
				 root =null;
			}
			else if(root.leftChild!=null && root.rightChild ==null){
				root= root.leftChild;
			}
			else if(root.leftChild==null && root.rightChild !=null){
				root =root.rightChild;
			}
			else{
				Node tempNode = root;
				root = findMinimum(root.rightChild);
				root.data.key =tempNode.data.key ;
				root.data.value =tempNode.data.value;
				root.rightChild = deleteKeyRecursively(root.rightChild, tempNode.data.key);
			}
		}
		return root;
	}
	
	/**
	 * Method getkeyValue
	 * @param {String}
	 */
	@Override
	public String getKeyValue(int data){
		Node node = this.root;
		while(node!=null)
		{
		
			if(node.data.key == data){
				return node.data.value ;
			}
			else if(node.data.key > data){
				node = node.leftChild;
			}
			else {
				node = node.rightChild;
			}
		}
		return "Value for this Key Does NOT EXIST";
	}
	
	/**
	 * Method getSorted list .
	 * @param node
	 */
	@Override
	public void getSortedList(Node root){
		
		if(root==null){
			return;
		}
		getSortedList(root.leftChild);
		list.add(root.data) ;
		getSortedList(root.rightChild);
	}
	
	/**
	 * Method getSorted list in range .]
	 * @param Node
	 */
	@Override
	public void getSortedListRange(Node root , int key1 ,int key2){
		
		if(root==null){
			return;
		}
		getSortedListRange(root.leftChild , key1, key2);
		
		if(root.data.key>= key1 && root.data.key<=key2){
			listRange.add(root.data);
		}
		getSortedListRange(root.rightChild , key1, key2);
	}
	
	/**
	 * Method for inorder traversal 
	 * @param root
	 */
	@Override
	public void inOrderTraversal(Node root){
		
		if(root==null){
			return ;
		}
	
		inOrderTraversal(root.leftChild);
		System.out.println("Key-> "+root.data.key+" "+ "data-> "+root.data.value);
		inOrderTraversal(root.rightChild);
	}	
}
