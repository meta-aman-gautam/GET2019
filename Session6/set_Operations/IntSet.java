package set_Operations;

import java.util.*;
/**
 * IntSet is a Immutable class which is Performing operations on Set,
 * such as subset checking , compliment,union of set.
 * 
 * @author Aman Gautam
 *
 *Dated 22/7/2019
 */
public final class IntSet {

	final int[] set;  //to create immutable array
	
	//constructor 
	IntSet(int[] inputSet) {
		if (inputSet.length == 0)
			throw new AssertionError("array can't be empty");
		set = inputSet;
	}

	/**
	 * checks if element present in set
	 * 
	 * @param element is the item to be searched
	 * @return boolean whether element exits in set
	 */
	boolean isMember(int element) {
		for (int count = 0; count < set.length; count++) {
			if (set[count] == element)
				return true;
		}
		return false;
	}

	/**
	 * find the size of set
	 * 
	 * @return the size of set
	 */
	int sizeOfSet() {
		int value = 0;
		for (int count = 0; count < set.length; count++)
			value++;
		return value;
	}

	/**
	 * check if given array is a subset of set
	 * 
	 * @param subSet is the input array to be checked for subset
	 * 
	 * @return boolean if input array is a subSet
	 */
	boolean isSubset(IntSet subSet) {
		int value = 0;
		for (int count = 0; count < subSet.set.length; count++) {
			if (isMember(subSet.set[count])) {
				value++;
			}
		}
		if (value == subSet.set.length) {
			return true;
		}
		return false;
	}

	/**
	 * to find the compliment of set
	 * 
	 * @return the complement object of set
	 */
	public IntSet getCompliment() {
		ArrayList<Integer> complement = new ArrayList<Integer>();
		for (int count = 1; count <= 1000; count++) {
			if (isMember(count)) {
				continue;
			} else
				complement.add(count);
		}
		int[] complementArray = new int[complement.size()];
		for (int count = 0; count < complement.size(); count++) {
			complementArray[count] = complement.get(count).intValue();
		}
		return new IntSet(complementArray);
	}
	
	/**
	 * Find union of the two set provided by user . 
	 * 
	 * @param set1 object 
	 * @param set2 object 
	 * 
	 @return unionArray
	 */
	public int[] union(IntSet set1, IntSet set2) {

		ArrayList<Integer> union = new ArrayList<Integer>();

		for (int count = 0; count < set1.set.length; count++) {
			if (!union.contains(set1.set[count])) {
				union.add(set1.set[count]);
			}
		}
		for (int count = 0; count < set2.set.length; count++) {
			if (!union.contains(set2.set[count])) {
				union.add(set2.set[count]);
			}
		}
		int[] unionArray = new int[union.size()];

		for (int count = 0; count < union.size(); count++) {
			unionArray[count] = union.get(count).intValue();
		}
		return unionArray;
	}
}