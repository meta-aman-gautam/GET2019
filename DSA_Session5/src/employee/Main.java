package employee;

import java.util.*;
/**
 * Intialization of main method
 * 
 * @author Aman Gautam
 * 
 * Dated - 06/08/2019
 */
public class Main {

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
						employeeObject = new Employee(employeeName, employeeSalary, employeeAge);
						employeeList = employeeList.insert(employeeList, employeeObject);
						noOfEmployee--;
					}
					employeeList.sortBySalary(employeeList);
					Node currentNode = employeeList.headNode;
					while (currentNode != null) {
						System.out.println("Name- " + currentNode.data.getEmployeeName() 
										+ "  Age- "	+ currentNode.data.getEmployeeAge()
								        + "  Salary- " + currentNode.data.getEmployeeSalary());
						
						currentNode = currentNode.next;
					}
					
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
			System.out.println("Invalid data....  Try again");
			main(args);

		}
	}
}
