package studentCouncelling;

import java.util.Queue;

/**
 * This is the initializtion of main class .
 * 
 * @author Aman Gautam
 * 
 * Dated 01/08/2019
 */

public class MainDriver {

	public static void main(String[] args) {
		FileOperation operation = new FileOperation();
		AllocateBranch allocate = new AllocateBranch();
		Queue<StudentList> studentQueue = null;
		try {
			studentQueue = operation.studentFileRead("StudentList.xls");
			operation.programFileRead("StudentList.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Queue<CounsellingResult> resultQueue = allocate.allocateBranch(studentQueue);
		
		operation.makeExcelSheet(resultQueue);
		System.out.println("Excel sheet created successfully..");
	}

}
