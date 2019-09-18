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
import org.springframework.web.servlet.ModelAndView;
import com.metacube.ead.assignment.dao.StudentDao;
import com.metacube.ead.assignment.entity.Student;

/**
 * The Class StudentController. Is used for the controller to 
 * send the data to subsequent layers .On hitting the url application 
 * directly comes to the controller via @Controller 
 * 
 *@author Aman Gautam
 *
 *Dated :18/9/19
 */
@Controller
public class StudentController {

	@Autowired
	StudentDao objDao; 
	
	@Value(value = "${home.welcome}")
	String welcome;

	/**
	 * Student form.
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
	 * submitStudentForm method is mapped to the url "localhost:8081/studentForm".
	 *
	 * @param Student
	 * @param BindingResult result 
	 * @param model 
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
			try{
				objDao.addStudent(student);
				answer= "index";
			}
			catch(Exception e){
				student.setEmail("EMAIL ALREADY USED");
				model.addAttribute(student);
				answer= "studentForm";
			}
			
		}
		return answer;
	}
	
	/**
	 * Show student method mapped to the url "localhost:8081/showStudent".
	 *
	 * @return the string
	 */
	@GetMapping("/showStudent")
	public String showStudent(Student student,Model model){
		List<Student> studentsList = new ArrayList<>();
		studentsList = objDao.showStudent();
		System.out.println(studentsList.get(0).getFatherName());
	    model.addAttribute("studentList" , studentsList);
		return "showStudent";
		
	}
	
	/**
	 * Home method which is the first method on hitting url "localhost:8081/index".
	 *
	 * @return the string
	 */
	@GetMapping("/index")
	public String home(Model model){
		model.addAttribute("welcome" , welcome);
		return "index";
	}

}
