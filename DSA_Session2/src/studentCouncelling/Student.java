package studentCouncelling;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String studentName ;
	List <String> listOfPrefrence = new ArrayList<String>();

	public Student(String studentName ,List listOfPrefrence){
		this.studentName =studentName;
		this.listOfPrefrence =listOfPrefrence;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public List<String> getListOfPrefrence() {
		return listOfPrefrence;
	}
}
