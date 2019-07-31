/**
 * Search for the element in the input Array Using linear or binary search
 * for binary search we assume the input array is sorted 
 * 
 * @author Aman Gautam
 * Dated 22/07/2019
 */
public class Search {

	private int index, count = 0,start,last,mid ,value=0;

	public int linearSearch(int[] inputarray, int element) {
		if (inputarray[inputarray.length - 1] == element)
			index = inputarray.length - 1;
		else {
			count++;
			if (inputarray[(inputarray.length - 1) - count] == element && ((inputarray.length - 1) - count) != 0) {
				index = (inputarray.length - 1) - count;
			}
			else if(inputarray[0]==element) {
				index = 0;
			}
			else{
				linearSearch(inputarray, element);
			}
		}
		return index;
	}
	
	/*
	 * Binary search method
	 */
	public int binarySearch(int inputArray[],int element){
		if(inputArray.length==0 )
			throw new AssertionError("Array empty");
		int start=0;
		int end=inputArray.length;
		int index=binarySearchRecursive(inputArray,start,end,element);
		
		return index;
		}
	
	/*
	 * helper method for the Binary Search 
	 */
	public static int binarySearchRecursive(int inputArray[], int startIndex,int arrayLength, int element) {
		if (arrayLength >= startIndex) {
			int mid = startIndex + (arrayLength - startIndex) / 2;
			if (inputArray[mid] == element)
				return mid;
			else if (inputArray[mid] > element)
				//calling recursion
				return binarySearchRecursive(inputArray, startIndex, mid - 1,element);
			return binarySearchRecursive(inputArray, mid + 1, arrayLength,element);
		}
		return -1;
	}
}

