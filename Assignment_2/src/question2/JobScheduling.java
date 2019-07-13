package question2;

import java.util.*;

public class JobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int processes, arrivaltime, bursttime, average = 0, greatest = 0;
		double averageWaitingTime = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of process ");
		processes = sc.nextInt();
		System.out.println("Enter the Arrival time and Burst time for each process respectively ");

		/*
		 * Initializing Arrays for as per their uses
		 */
		int[][] list = new int[processes][2];
		int[] startTime = new int[processes];
		int[] completionTime = new int[processes];
		int[] waitingTime = new int[processes];
		int[] turnaroundtime = new int[processes];

		for (int i = 0; i < processes; i++) {
			System.out.print("For P" + i + "-");
			arrivaltime = sc.nextInt();
			list[i][0] = arrivaltime;
			bursttime = sc.nextInt();
			list[i][1] = bursttime;

		}

		sortbyColumn(list, 0);

		/*
		 * MAIN logic of the code to calculate
		 */

		for (int i = 0; i < processes; i++) {
			if (i == 0) {
				startTime[i] = list[i][0];
				waitingTime[i] = startTime[i];
				completionTime[i] = list[i][1] + startTime[i];
				turnaroundtime[i] = completionTime[i] - list[i][0];
			} else {
				if (list[i][0] <= list[i - 1][1]) {
					startTime[i] = list[i - 1][1];
					waitingTime[i] = startTime[i] - list[i][0];
					completionTime[i] = list[i][1] + startTime[i];
					turnaroundtime[i] = completionTime[i] - list[i][0];
				} else {
					startTime[i] = list[i][0];
					waitingTime[i] = 0;
					completionTime[i] = list[i][1] + startTime[i];
					turnaroundtime[i] = completionTime[i] - list[i][0];
				}

			}
		}
/*
 * Displaying the output in the TABULAR FORM 
 */
		System.out.println("Start " + "Arrival " + "Burst " + "Completion " + "TurnAround " + " Waiting ");
		System.out.println("------ " + "------- " + "----- " + "---------- " + "---------- " + "------- ");
		for (int i = 0; i < processes; i++) {
			System.out.println(startTime[i] + "\t" + list[i][0] + "\t" + list[i][1] + "\t" + completionTime[i] + "\t   "
					+ turnaroundtime[i] + "\t     " + waitingTime[i]);

		}

		for (int i = 0; i < processes; i++) {
			average = average + waitingTime[i];
			if (i == 0) {
				greatest = waitingTime[i];
			} else if (waitingTime[i] > waitingTime[i - 1]) {
				greatest = waitingTime[i];
			}
		}
		System.out.println("--------------------------------------------------");
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
		// Using built-in sort function Arrays.sort
		Arrays.sort(list, new Comparator<int[]>() {

			@Override
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {

			
				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		}); // End of function call sort().
	}

}
