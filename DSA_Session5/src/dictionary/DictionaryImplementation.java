package dictionary;

import java.util.*;

import org.json.simple.JSONObject;

public class DictionaryImplementation implements Dictionary {
	BSTNode headNode;
	
	/**
	 * parameterized constructor
	 * @input json object
   	 */
	public DictionaryImplementation(JSONObject jsonObject) {
		this.headNode = null;
		this.input(jsonObject);
	}
	
	//default constructor
	public DictionaryImplementation() {
	}

	/**
	 * method for add key and value from json object
	 * @param jsonObject
	 */
	private boolean input(JSONObject jsonObject){
		
		for(Object obj : jsonObject.keySet()){
			String key = (String)obj;
			String value = (String) jsonObject.get(key);
			this.addKeyValue(key, value);
		}
		return true;
	}



	/**
	 * method for add key and value in BST
	 */

	@Override
	public boolean addKeyValue(String key, String value){
		if (key.length() == 0 || value.length() == 0 || key == null || value == null) {
			System.out.println("Invalid key or value");
		}
		if (headNode == null) {
			headNode = new BSTNode(key, value);
		} else {
			addRecursively(key, value, headNode);
		}
		return false;
	}

	/**
	 * Recursive function for adding key and value in BST
	 * @param key {String Type}
	 * @param value {String Type}
	 * @param node {BSTNode type}
	 * @return {Boolean value}
	 */
	private boolean addRecursively(String key, String value, BSTNode node) {
		// go left if key less than current node key
		if (key.compareTo(node.getKey()) < 0) {
			if (node.getLeftChild() != null) {
				// if left is present call recursive
				addRecursively(key, value, node.getLeftChild());
			} else {
				// add value to left
				node.setLeftChild(new BSTNode(key, value));
				node.getLeftChild().setParentNode(node);
			}
		}
		// go right if key is greater than current node key
		else if (key.compareTo(node.getKey()) > 0) {
			if (node.getRightChild() != null) {
				// if right is present call recursive
				addRecursively(key, value, node.getRightChild());
			} else {
				// add value to right
				node.setRightChild(new BSTNode(key, value));
				node.getRightChild().setParentNode(node);
			}
		} else {
			node = new BSTNode(key, value);
		}
		return true;
	}


	/**
	 * method for delete a key and value form BST 0
	 * @param key {String Type}
	 */
	@Override
	public boolean deleteKeyValue(String key) {

		if (key.length() == 0 || key == null) {
			System.out.println("Invalid key...");
		}

		else if (headNode != null) {
			return deleteRecursively(key, headNode);
		}
		return false;
	}

	/**
	 * recursive function for deleting a key form BST
	 * @param key{String Type}
	 * @param node{BSTNode Type }
	 * @return {Boolean value}
	 */
	private boolean deleteRecursively(String key, BSTNode node) {
		// go left if key less than current node key
		if (key.compareTo(node.getKey()) < 0) {
			if (node.getLeftChild() != null) {
				// if left is present call recursive
				return deleteRecursively(key, node.getLeftChild());
			}
		}
		// go right if key is greater than current node key
		else if (key.compareTo(node.getKey()) > 0) {
			if (node.getRightChild() != null) {
				// if right is present call recursive
				return deleteRecursively(key, node.getRightChild());
			}
		}
		// if key is equal to node key
		else if (key.compareTo(node.getKey()) == 0) {
			// check if it is a leaf node
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				if (node.getParentNode() == null) {
					headNode = null;
				}
				// set parent child null if it is leaf node
				else if (node.getParentNode().getLeftChild() == node) {
					node.getParentNode().setLeftChild(null);
				} else {
					node.getParentNode().setRightChild(null);
				}
			}
			// if left node is null
			else if (node.getLeftChild() == null && node.getRightChild() != null) {
				if (node.getParentNode() == null) {
					BSTNode newNode = findMinimum(node.getRightChild());
					node.setKey(newNode.getKey());
					node.setValue(newNode.getValue());
					return deleteRecursively(newNode.getKey(), newNode);
				}
				// if self is left than set parent left else set parent right
				else if (node.getParentNode().getLeftChild() == node) {
					node.getParentNode().setLeftChild(node.getRightChild());
				} else {
					node.getParentNode().setRightChild(node.getRightChild());
				}
			}
			// if right is null
			else if (node.getRightChild() == null && node.getLeftChild() != null) {
				// if self is right set parent right else set parent left
				if (node.getParentNode().getRightChild() == node) {
					node.getParentNode().setRightChild(node.getLeftChild());
				} else {
					node.getParentNode().setLeftChild(node.getLeftChild());
				}
			}

			else {
				BSTNode newNode = findMinimum(node.getRightChild());
				node.setKey(newNode.getKey());
				node.setValue(newNode.getValue());
				return deleteRecursively(newNode.getKey(), newNode);
			}
		}
		return true;

	}

	/**
	 * method to find minimum value from tree
	 * @param currentNode {BSTNode type}
	 * @return currentNode {BSTNode type}
	 */
	private BSTNode findMinimum(BSTNode currentNode) {
		while (currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;

	}

	/**
	 * method to traverse tree using InOrderTraversing
	 * @param root{BSTNode type}
	 * @param list{List type}
	 * @return list{List type}
	 */
	private List<Value> inorderRecursion(BSTNode root, List<Value> list) {
		if (root != null) {
			inorderRecursion(root.leftChild, list);
			list.add(new Value(root.getKey(), root.getValue()));
			inorderRecursion(root.rightChild, list);
		}
		return list;
	}

	/**
	 * method to find a value with key 
	 * @param key{String type}
	 */
	@Override
	public String getValue(String key) {
		if (headNode != null) {
			return getValueRecursion(key, headNode);
		}
		return null;
	}

	/**
	 * recursive method to find a value form tree
	 * @param key {String type}
	 * @param node{BSTNode type}
	 * @return {String type}
	 */
	private String getValueRecursion(String key, BSTNode node) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.getKey()) == 0) {
			return node.getValue();
		} else if (key.compareTo(node.getKey()) < 0) {
			return getValueRecursion(key, node.getLeftChild());
		} else if (key.compareTo(node.getKey()) > 0) {
			return getValueRecursion(key, node.getRightChild());
		} else
			return null;
	}

	/*
	 * method to find all values from tree
	 */
	@Override
	public List<Value> getAllKeys() {
		List<Value> valueList = new ArrayList<Value>();
		if (headNode != null) {
			valueList = inorderRecursion(headNode, valueList);
		}
		return valueList;
	}

	/**
	 * method to find list of key/value pairs between keys(inclusive at both ends) 
	 * @param key1 {String type}
	 * @param key2 {String type}
	 */
	@Override
	public List<Value> getBetweenTwoKeys(String key1, String key2) {
		List<Value> list = getAllKeys();
		List<Value> finalList = new ArrayList<Value>();
		for (Value v : list) {
			if (v.getKey().compareTo(key1) >= 0 && v.getKey().compareTo(key2) <= 0) {
				finalList.add(v);
			}
		}
		return finalList;
	}

	public void display(List<Value> valueList) {
		for (int i = 0; i < valueList.size(); i++) {
			System.out.println("Key-" + valueList.get(i).getKey()
								+ " value-"+ valueList.get(i).getValue());
		}
	}
}