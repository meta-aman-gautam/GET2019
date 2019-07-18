package jobScheduling;

import java.util.*;

/**
 * jobScheduling class is the base class for the package jobScheduling .
 *
 * @auther Aman Gautam
 * 
 * dated 15/07/2019
 */
public class JobScheduling {

	public static void main(String[] args) {

		int processes, arrivaltime, bursttime, average = 0, greatest = 0;
		double averageWaitingTime = 0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no of process ");
		processes = sc.nextInt();
		System.out.println("Enter the Arrival time and Burst time for each process respectively ");
		
		//Declaring and Initializing Arrays for as per their uses
		int[][] inputArray = new int[processes][2];
		int[] startTime = new int[processes];
		int[] completionTime = new int[processes];
		int[] waitingTime = new int[processes];
		int[] turnaroundtime = new int[processes];
	
		for (int i = 0; i < processes; i++) {
			System.out.print("For P" + i + "-");
			arrivaltime = sc.nextInt();
			inputArray[i][0] = arrivaltime;
			bursttime = sc.nextInt();
			inputArray[i][1] = bursttime;
		}
		
		// this method is used to sort the inputArray in increasing order 
		sortbyColumn(inputArray, 0);

		//Initialization of the Main Method
		for (int i = 0; i < processes; i++) {
			if (i == 0) {
				startTime[i] = inputArray[i][0];
				waitingTime[i] = startTime[i];
				completionTime[i] = inputArray[i][1] + startTime[i];
				turnaroundtime[i] = completionTime[i] - inputArray[i][0];
			} else {
				if (inputArray[i][0] <= inputArray[i - 1][1]) {
					startTime[i] = inputArray[i - 1][1];
					waitingTime[i] = startTime[i] - inputArray[i][0];
					completionTime[i] = inputArray[i][1] + startTime[i];
					turnaroundtime[i] = completionTime[i] - inputArray[i][0];
				} else {
					startTime[i] = inputArray[i][0];
					waitingTime[i] = 0;
					completionTime[i] = inputArray[i][1] + startTime[i];
					turnaroundtime[i] = completionTime[i] - inputArray[i][0];
				}
			}
		}
		
		/*
		 * Displaying the output in the TABULAR FORM for method Arrival Time
		 * Burst Time
		 */
		System.out.println("Start Time\t" + "Arrival Time\t" + "Burst Time\t" 
							+ "Completion Time \t" + "TurnAround Time\t" + " Waiting Time\t");
		System.out.println("----------\t" + "------------\t" + "----------\t"
							+ "----------------\t" + "---------------\t"
							+ "-------------\t");
		
		for (int i = 0; i < processes; i++) {
			System.out.println("\t" + startTime[i] + "\t\t" + inputArray[i][0]
					          + "\t\t" + inputArray[i][1] + "\t\t" + completionTime[i]
					          + "\t\t" + turnaroundtime[i] + "\t\t" + waitingTime[i]);
		}
		for (int i = 0; i < processes; i++) {
			average = average + waitingTime[i];
			if (i == 0) {
				greatest = waitingTime[i];
			} 
			else if (waitingTime[i] > waitingTime[i - 1]){
				greatest = waitingTime[i];
			}
		}
		System.out.println("----------\t" + "------------\t" 
						+ "----------\t"+ "---------------\t" 
						+ "---------------\t"+ "-------------\t");
		averageWaitingTime = average;
		System.out.println("Average Waiting Time = " + averageWaitingTime / processes);
		System.out.println("Maximum Waiting Time = " + greatest);
	}

	/**
	 * this is sortbyColumn method which is used to sort the input 2d array by
	 * Arrival Time(column)
	 * 
	 * @param list is a 2D static array
	 * @param col  is Arrival time by reference
	 */
	public static void sortbyColumn(int list[][], int col) {
		
		//Using built-in sort function Arrays.sort
		Arrays.sort(list, new Comparator<int[]>() {
			
			//Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {
				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		}); 
	}
}
