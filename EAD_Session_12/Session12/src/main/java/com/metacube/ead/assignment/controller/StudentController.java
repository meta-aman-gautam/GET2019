package com.metacube.ead.assignment.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.metacube.ead.assignment.entity.Student;
import com.metacube.ead.assignment.repository.StudentRepository;

/**
 * The Class StudentController. Is used for the controller to 
 * send the data to subsequent layers .On hitting the url application 
 * directly comes to the controller via @Controller 
 * 
 * @author Aman Gautam
 * 
 * Dated 19/9/19
 */
@Controller
public class StudentController {

	@Autowired
	StudentRepository objRepo;

	
	@Value(value = "${home.welcome}")
	String welcome;

	/**
	 * studentForm() method is mapped to the url "localhost:8081/studentForm"
	 * this method is used to add the attribute of the new student to the form
	 * and return it to the studentForm.jsp
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/studentForm")
	public String studentForm(Model model){
		model.addAttribute(new Student());
		return "studentForm";
	}

	/**
	 * submitStudentForm() method is mapped to the url "localhost:8081/studentForm".
	 *
	 * @param student
	 * @param BindingResult
	 * @param mode
	 * @return string
	 */
	@PostMapping("/studentForm")
	public String submitStudentForm( @Validated Student student ,BindingResult result,Model model){
		String answer ;
		if(result.hasErrors()){
			model.addAttribute(student);
			answer= "studentForm";
		}
		else{
			List<Student> list = new ArrayList<>();
			list =objRepo.findByEmailContainingIgnoreCase(student.getEmail());
			if(list.size()>0) {
				student.setEmail("Email Already Used");
				answer = "studentForm";
			}
			else {
				String firstName = student.getFirstName();
				String lastName = student.getLastName();
				String fatherName = student.getFatherName();
				String email = student.getEmail();
				int studentClass = student.getStudentClass();
				int age = student.getAge();
				if(objRepo.insertStudent(age, email, fatherName, firstName, lastName, studentClass)>0) {
					answer="index";
				}
				else {
					answer="studentForm";
				}
			}
			
		}
		return answer;
	}
	
	/**
	 *Show student method mapped to the url "localhost:8081/showStudent".
	 *
	 * @return the string
	 */
	@GetMapping("/showStudent")
	public String showStudent(Student student,Model model){
		List<Student> studentsList = new ArrayList<>();
		studentsList = objRepo.findAll();
	    model.addAttribute("studentList" , studentsList);
		return "showStudent";
		
	}
	
	/**
	 *Home method which is the first method on hitting url "localhost:8081/index".
	 *
	 * @return the string
	 */
	@GetMapping("/index")
	public String home(Model model){
		model.addAttribute("welcome" , welcome);
		return "index";
	}

}
