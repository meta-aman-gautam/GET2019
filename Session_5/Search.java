
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
				
			} else{
				linearSearch(inputarray, element);
			}
		}
		return index;
	}
	
	public int binarySearch(int inputArray[],int element){
		if(inputArray.length==0 )
			throw new AssertionError("Array empty");
		int start=0 ,end=inputArray.length ,index=binarySearchRecorsive(inputArray,start,end,element);
		return index;
		}

	public static int binarySearchRecorsive(int inputArray[], int startIndex,int arrayLength, int element) {
		if (arrayLength >= startIndex) {
			answer = 0;
			int mid = startIndex + (arrayLength - startIndex) / 2;
			if (inputArray[mid] == element){
				answer = mid;
			}
			else if (inputArray[mid] > element){
				answer = binarySearchRecorsive(inputArray, startIndex, mid - 1,element);
			}
			answer = binarySearchRecorsive(inputArray, mid + 1, arrayLength,element);
		}
		return answer ;
	}
}
