package employee;

import java.util.Scanner;
/**
 * Driver Class
 * 
 * @author Aman Gautam
 * 
 * Dated - 11/08/2019
 */
public class Main{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		try {
			LinkedList employeeList = new LinkedList();
			Employee employeeObject;
			Scanner input = new Scanner(System.in);
			String employeeName;
			int employeeAge, noOfEmployee, flag;
			double employeeSalary;
			while (true) {
				System.out.println("enter no. of employee");
				noOfEmployee = input.nextInt();
				if (noOfEmployee > 0) {

					loop:while (noOfEmployee != 0) {
						input.nextLine();
						System.out.println("enter Name of employee");
						employeeName = input.nextLine();
						System.out.println("enter Age. of employee");
						employeeAge = input.nextInt();
						if(employeeAge<18 ||employeeAge>100 ){
							System.out.println("Age of employee cannot be smaller than 18 years or greater than 100 years");
							System.out.println("Pls try again");
							continue loop;
						}
						System.out.println("enter Salary of employee");
						employeeSalary = input.nextDouble();
						employeeObject = new Employee(employeeName, employeeAge, employeeSalary);
						employeeList.insertEmployee(employeeObject);
						noOfEmployee--;
					}
					employeeList.show();
					System.out.println("Sorted -->");
					employeeList.sortBySalary();
					employeeList.show();
					
					
					System.out.println("Press 0 to exit or any number to continue");
					flag = input.nextInt();
					input.nextLine();
					
					if (flag == 0) {
						System.out.println("Exiting program....");
						System.exit(0);
					}
					input.close();
				} else
					System.out.println("Employees number can't be null or negative");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			main(args);

		}
	}
}

		
