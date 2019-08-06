package dictionary;

/**
 * Class Binary search tree node
 * 
 * @author Aman Gautam
 * 
 *Dated -06/08/2019
 */
public class BSTNode {
	private String key;
	private String value;
	BSTNode left,right,parent;
	
	//constructor 
	public BSTNode(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	//getter  and setter methods 
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}

	
	public String getValue() {
		return value;
	}

	
	public void setValue(String value) {
		this.value = value;
	}

	
	public BSTNode getLeft() {
		return left;
	}

	
	public void setLeft(BSTNode left) {
		this.left = left;
	}


	public BSTNode getRight() {
		return right;
	}


	public void setRight(BSTNode right) {
		this.right = right;
	}


	public BSTNode getParent() {
		return parent;
	}

	
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}	
}
