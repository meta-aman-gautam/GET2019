package marksCalculation;

import java.util.Scanner;

/**class Mark sheet calculates various things such as average ,
 * passing percentage, maximum , minimum of all grades. 
 * 
 * @author Aman Gautam
 * 
 * Dated -17/07/2019
 */
public class Marksheet {
	
	private int NoOfStudents,validgrade,grades[];
	
	Scanner sc = new Scanner(System.in);

	// void method for taking the inputs from the user
	public void input() {
		System.out.println("Enter the no of Students");
		NoOfStudents = sc.nextInt();
		grades = new int[NoOfStudents];
		System.out.println("Enter the grades of Students");
		for (int count = 0; count < NoOfStudents; count++) {
			validgrade = sc.nextInt();
			if (validgrade >= 0 && validgrade <= 100) {
				grades[count] = validgrade;
			} else {
				System.out.println("invalid grade");
				input();
				break;
			}
		}
	}

	/**
	 * this method is used for calculating the average of the grades.
	 * 
	 * @return {double}average
	 */
	public double average() {
		float average = 0;
		for (int count = 0; count < NoOfStudents; count++) {
			average += (grades[count]);
		}
		average= average/NoOfStudents;
		//Rounding off to TWO DECIMAL places 
		return Math.round(average * 100.0) / 100.0;
	}
	
	/**
	 * Method  for calculating the maximum of all grades 
	 * 
	 * @return {Integer}maximum grade
	 */
	public int maximum() {
		int maximum = 0;
		for (int count = 0; count < NoOfStudents; count++) {
			if (maximum <= grades[count]) {
				maximum = grades[count];
			}
		}
		return maximum;
	}
	
	/**
	 * Method for calculating the minimum of all grades .
	 * 
	 * @return {integer}minimmum grade
	 */
	public int minimum() {
		int minimum = 100;
		for (int count = 0; count < NoOfStudents; count++) {
			if (minimum >= grades[count]) {
				minimum = grades[count];
			}
		}
		return minimum;
	}
	
	/**
	 *Method for calculating percentage of students passed .(grade >40 is passed) 
	 * 
	 * @return {double} passingpercentage
	 */
	public double passedPercentage() {
		double passingpercentage = 0;
		float flag =0;
		for (int count = 0; count < NoOfStudents; count++) {
			if (grades[count] >= 40) {
				flag++;
			}
		}
		passingpercentage =(flag* 100)/NoOfStudents ;
		//Rounding off to TWO DECIMAL places 
		return Math.round(passingpercentage * 100.0) / 100.0;
	}
}
