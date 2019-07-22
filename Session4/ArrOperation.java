import java.security.acl.LastOwnerException;
import java.util.ArrayList;

/**
 * Return the size of the largest mirror section found in the input array.
 * Return the number of clumps in the input array.
 * Solve fixXY problem
 * Return the index if there is a place to split the input array 
 *
 * @author Aman Gautam 
 * 
 * Dated 18/07/2019
 */
public class ArrOperation{
	int maxMirror(int mirrorArray[]) {

		if (mirrorArray.length == 0)
			throw new AssertionError("Array size cannot be zero");

		int maxLength = 0,tempLength = 0,pivot;
		
		for (int indexI = 0; indexI < mirrorArray.length; indexI++) {
			pivot = indexI;
			tempLength = 0;
			for (int indexJ = mirrorArray.length - 1; indexJ >= indexI; indexJ--) {
				if (mirrorArray[pivot] == mirrorArray[indexJ]) {
					tempLength++;
					pivot++;
				} else if (tempLength > maxLength) {
					maxLength = tempLength;
					tempLength = 0;
					pivot = indexI;
				} else if(pivot!=indexI){
					tempLength = 0;
					pivot = indexI;
					indexJ++;
				}
				if (tempLength > maxLength)
					maxLength = tempLength;
			}
		}
		return maxLength;
	}
	
	/**Return the number of clumps in the input array.
	 * 
	 * @param inputarray[]
	 * @return clumps
	 */
	 static int noofClumps(int[] inputarray) {
		int clumps = 0, LastIndex;
		boolean CheckingStatus;

		if (inputarray.length == 0)
			throw new AssertionError("Array size cannot be zero");
		for (int FirstIndex = 0; FirstIndex < inputarray.length; FirstIndex++) {
			CheckingStatus = false;
			for (LastIndex = 1; (LastIndex + FirstIndex) < inputarray.length; LastIndex++) {
				if (inputarray[FirstIndex] == inputarray[LastIndex + FirstIndex]) {
					CheckingStatus = true;
				} else
					break;
			}
			if (CheckingStatus) {
				clumps++;
				FirstIndex = FirstIndex + LastIndex - 1;
			}
		}
		System.out.println(clumps);
		return clumps;
	}

	
	static boolean checkadjecency(int[] inputarray ,int X) {
		for(int count=0;count<inputarray.length-1;count++)
		{
			if(inputarray[count]==X && inputarray[count+1]==X) {
				return true;
			}
		}
		return false;
	}
	
	static int countOf_XorY(int[] inputArray, int X) {
		int countOf = 0;
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count] == X)
				countOf++;
		}
		return countOf;
	}
	
	/*
	 *Return an array that contains exactly the same numbers as the input array,
	 *but rearranged so that every X is immediately followed by a Y. 
	 *Do not move X within array, but every other number may move.
	 *
	 */
	static int[] fixXY(int[] inputarray ,int X,int Y) {
		
		//Assertion error case 1 ...
		if (inputarray.length == 0)
			throw new AssertionError("Array size cannot be zero");
		//Assertion error case 2 ...
		else if(checkadjecency(inputarray, X))
			throw new AssertionError("Array should not contain adjacent X");
		//Assertion error case 3 ...	
		else if(countOf_XorY(inputarray, X)!=countOf_XorY(inputarray, X))
			throw new AssertionError("Array should contain equal Xs and Ys");
		//Assertion error case 4 ...
		else if(inputarray[inputarray.length-1] == X)
			throw new AssertionError("Array should not contain last element as X");
		/*
		 * array list created to store the index of values of inputarray
		 * which are equal to X(user input)
		 */
		ArrayList<Integer> index = new ArrayList<Integer>();
		int []aux =new int[1]  ; 
		for(int count=0;count<inputarray.length;count++)
		{
			if(count==0 && inputarray[count]==Y)
				index.add(count);
			else if(count>0 && inputarray[count]==Y && inputarray[count-1]!=X) {
				index.add(count);
			}
		}	
		for (int count = 0;count<inputarray.length; count++) {
			if(inputarray[count]==X && inputarray[count+1]!=Y) {
				aux[0]= inputarray[count+1];
				inputarray[count+1]=inputarray[index.get(0)];
				inputarray[index.get(0)]=aux[0];
				index.remove(0);
			}
		}
		return inputarray ;
	}

	
	/*
	 * Return the index if there is a place to split the input array so
	 *  that the sum of the numbers on one side is equal to the sum 
	 *  of the numbers on the other side else return -1 .
	 */
	static int split(int splitArray[]) {
		int ReturnValue ,index ;
		
		if (splitArray.length == 0)
			throw new AssertionError("Array size cannot be zero");
		
		int sum = 0, leftSum = 0, rightSum = 0;
		for (int count = 0; count < splitArray.length; count++) {
			sum += splitArray[count];
		}
		if (sum % 2 != 0){
			ReturnValue =-1;
			return ReturnValue;
	    	}
	
		for (index = splitArray.length - 1; index > 0; index--) {
			rightSum += splitArray[index];
			leftSum = sum - rightSum;
			if (leftSum == rightSum) {
				ReturnValue= index;
				return ReturnValue;
			}
		}
		if (index == 0){
			ReturnValue = -1;
			return ReturnValue;
		}
		ReturnValue =-1;
		return ReturnValue;
	}
}
