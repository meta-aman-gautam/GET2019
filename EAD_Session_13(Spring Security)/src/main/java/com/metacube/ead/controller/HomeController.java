package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Student;
import com.example.demo.service.UserService;

/**
 * The Class HomeController. is the first layer encountered after hitting the url
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
 */
@Controller
public class HomeController {
	

	@Autowired
	UserService userService;

	@Value("${msg}")
	private String message;

	/**
	 * Welcome student.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/welcome")
	public String welcomeStudent(Model model) {
		return "welcome";
	}

	/**
	 * Home method is mapped to the index url .
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("msg", message);
		return "index";
	}

	/**
	 * Do login method is used to map the login method with .
	 *
	 * @param error
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doLogin(@RequestParam(value = "error", required = false) String error,Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		System.out.println("THE ERROR " + errorMessge);
		return "login";
	}

	/**
	 * Adds the student.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		Student user = new Student();
		model.addAttribute("userform", user);
		return "addStudent";
	}

	/**
	 * Show student , method is mapped with show student page 
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> studentList = userService.getUser();
		model.addAttribute("users", studentList);
		return "showStudent";
	}

	/**
	 * Do login Get method .
	 *
	 * @param user the user
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String doLogin(@ModelAttribute("userform") @Validated Student user,BindingResult result, Model model) {
		System.out.println("I am here in do login");
		if (result.hasErrors()) {
			System.out.println("Error present");
			return "addStudent";
		}
		model.addAttribute("student", user);
		try {
			userService.createUser(user);
		} catch (Exception e) {
			model.addAttribute("error","Please Choose  different Email and try again");
			return "index";
		}
		return "detail";
	}

	/**
	 * Do search email method is mapped to the emailsearch .
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "emailSearch", method = RequestMethod.GET)
	public String doSearchEmail(Model model) {
		Student user = new Student();
		model.addAttribute("userforms", user);
		return "emailsearch";
	}

	/**
	 * Show student email .
	 *
	 * @param user the user
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/showemail")
	public String showStudentEmail(@ModelAttribute("userforms") Student user,Model model) {
		String emailID = user.getEmail();
		System.out.println("THE EMAIL ID " + emailID);
		Student searched = userService.getByEmail(emailID);
		System.out.println("THE LIST IS" + searched.getFirstName());
		model.addAttribute("user", searched);
		return "emailShow";
	}
}