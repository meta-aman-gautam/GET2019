package com.ead_session_2;

public class MyQuery {

	public String addStudent(String firstName,String lastName,String email,String fatherName,int studentclass,int age){
		String answer ="INSERT INTO studentdetails "
				+"(firstname,lastname,fathername,email,class,age) VALUES "
				+"('"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+email+"',"+studentclass+","+age+")";
		return answer ;
	}
	
	
	public String showStudent(){
		String answer ="SELECT * FROM studentdetails";
		return answer ;
	}
	
	public String updateDetails(int studentId ,String firstName,String lastName,String email,String fatherName,int studentclass,int age){
		String answer = "Update studentdetails set"
						+" firstname = '"+firstName
						+"', lastname ='"+lastName
						+"', fathername ='"+fatherName
						+"', email='"+email
						+"', class="+studentclass
						+", age = "+age
						+" WHERE studentid = "+studentId;
		return answer;
	}
	
	public String SearchByName(String firstName,String lastName){
		String answer = "select * from studentdetails WHERE firstname = '"+firstName+"' and lastname ='"+lastName+"'";
		return answer;
	}
	
	public String SearchByClass(String firstName,String lastName ,int classname){
		String answer = "select * from studentdetails WHERE firstname = '"+firstName+"' and lastname ='"+lastName+"' and class= "+classname;
		return answer;
	}
}
