package com.metacube.ead.session8.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.metacube.ead.session8.springmvc.model.StudentDetails;

/**
 * The Class HomeController which acts as the controller layer connecting to 
 * the dispatcher servlet .Application lets you enter the details of the student 
 * 
 * @author Aman Gautam
 * 
 * Dated : 13/9/19
 */
@Controller
public class HomeController {

	@Value("${home.welcome}")
	private String WelcomeMessage ;
	
	/**
	 * At home method mapped to the /home url .
	 *
	 * @param model object
	 * @return  to home.jsp 
	 */
	@GetMapping("/home")
	public String atHome(Model model){
		model.addAttribute("welcome",WelcomeMessage);
		return "home";
	}
	
	/**
	 * At student method which is mapped to the /home/student url in browesr.
	 *
	 * @param model object
	 * @return to addStudent.jsp
	 */
	@GetMapping("/home/addStudent")
	public String atStudent(Model model){
		model.addAttribute("studentDetails",new StudentDetails());
		return "addStudent";
	}
	
	/**
	 * addedStudent method which is mapped to the url of home/success.
	 *
	 * @return to string.jsp
	 */
	@GetMapping("/success")
	public String addedStudent(){
		return "success";
	}
	
	/**
	 * Prepared list of type StudentDetails.
	 *
	 * @return list{Student}
	 */
	public List<StudentDetails> preparedList(){
		List<StudentDetails> listOfStudents = new ArrayList<>();
		listOfStudents.add(new StudentDetails("Aman","Gautam","Mr Ravindra Kumar","amangautam780@gmail.com",12,15));
		listOfStudents.add(new StudentDetails("Anmol","Babbar","Mr Babbar","babbarShera@gmail.com",10,11));
		listOfStudents.add(new StudentDetails("Jugal","Kukreja","Mr Kukreja","jugal123@gmail.com",7,20));
		listOfStudents.add(new StudentDetails("Mahendar","Saran","Mr Saran","mahindar123@gmail.com",8,18));
		listOfStudents.add(new StudentDetails("Ajay","Shringi","Mr Shringi","ajay1234@gmail.com",11,16));
		return listOfStudents;
	}
	
	/**
	 * showStudent method which is mapped to the /home/showStudent url .
	 *
	 * @param model object 
	 * @return showStudent.jsp
	 */
	@GetMapping("/home/showStudent")
	public String showStudent(Model model){
		model.addAttribute("list",preparedList());
		return "showStudent";
	}
	
	/**
	 * atHome method mapped to the url "/home/addStudent" when the form is submitted  .
	 *
	 * @param user{StudentDetails}
	 * @param result
	 * @return addStudent.jsp if unsuccessful otherwise success.jsp
	 */
	@PostMapping("/home/addStudent")
	public String atHome(@Validated StudentDetails student , BindingResult result){
		if(result.hasErrors()){
			return "addStudent";
		}
		else{
			System.out.println(student);
			return "redirect:/home";
		}
	}
	
}
