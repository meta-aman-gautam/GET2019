package com.ead_session_2;

/**
 * The Class MyQuery where all the queries are writen and updated.
 * @author Aman Gautam
 * Dated 9/7/19
 */
public class MyQuery {

	/**
	 * Adds the student to the database using form.
	 *
	 * @param firstName
	 * @param lastName 
	 * @param email
	 * @param fatherName
	 * @param studentclass 
	 * @param age 
	 * @return  string
	 */
	public String addStudent(String firstName,String lastName,String email,String fatherName,int studentclass,int age){
		String answer ="INSERT INTO studentdetails "
				+"(firstname,lastname,fathername,email,class,age) VALUES "
				+"('"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+email+"',"+studentclass+","+age+")";
		return answer ;
	}
	
	/**
	 * Show student.
	 *
	 * @return the string
	 */
	public String showStudent(){
		String answer ="SELECT * FROM studentdetails";
		return answer ;
	}
	
	/**
	 * Update details in the database .
	 *
	 * @param studentId
	 * @param firstName 
	 * @param lastName
	 * @param email
	 * @param fatherName 
	 * @param studentclass 
	 * @param age
	 * @return string
	 */
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
	
	/**
	 * Search by name in the database .
	 *
	 * @param firstName
	 * @param lastName 
	 * @return string
	 */
	public String SearchByName(String firstName,String lastName){
		String answer = "select * from studentdetails WHERE firstname = '"+firstName+"' and lastname ='"+lastName+"'";
		return answer;
	}
	
	/**
	 * Search by class in the data base.
	 *
	 * @param firstName 
	 * @param lastName
	 * @param classname 
	 * @return string
	 */
	public String SearchByClass(String firstName,String lastName ,int classname){
		String answer = "select * from studentdetails WHERE firstname = '"+firstName+"' and lastname ='"+lastName+"' and class= "+classname;
		return answer;
	}
}
