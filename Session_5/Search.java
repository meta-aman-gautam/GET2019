
public class Search {

	private int index, count = 0,start,last,mid ,value=0;

	public int linearSearch(int[] inputarray, int element) {
		if (inputarray[inputarray.length - 1] == element)
			index = inputarray.length - 1;
		else {
			count++;
			if (inputarray[(inputarray.length - 1) - count] == element && ((inputarray.length - 1) - count) != 0) {
				index = (inputarray.length - 1) - count;
				return index;
			}
			else if(inputarray[0]==element) {
				index = 0;
				
			} else
				linearSearch(inputarray, element);
		}
		return index;
	}
	
	public int binarySearch(int inputArray[],int element){
		if(inputArray.length==0 )
		throw new AssertionError("Array empty");
		int start=0;
		int end=inputArray.length;
		int index=binarySearchRecorsive(inputArray,start,end,element);
		return index;
		}

	public static int binarySearchRecorsive(int inputArray[], int startIndex,int arrayLength, int element) {
		if (arrayLength >= startIndex) {
			int mid = startIndex + (arrayLength - startIndex) / 2;
			if (inputArray[mid] == element)
				return mid;
			if (inputArray[mid] > element)
				return binarySearchRecorsive(inputArray, startIndex, mid - 1,
						element);
			return binarySearchRecorsive(inputArray, mid + 1, arrayLength,element);
		}
		return -1;
	}
}


















