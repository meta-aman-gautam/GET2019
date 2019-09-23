package com.metacube.ead.springSecurity.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.metacube.ead.springSecurity.model.Student;
import com.metacube.ead.springSecurity.service.UserService;

@RestController
public class HomeController {
	@Autowired
	UserService userService;

	@Value("${msg}")
	private String message;

	@RequestMapping("/welcome")
	public String welcomeStudent(Model model) {
		return "welcome";
	}

	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("msg", message);
		System.out.println("I am here " + message);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doLogin(
			@RequestParam(value = "error", required = false) String error,
			Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}

		model.addAttribute("errorMessge", errorMessge);
		System.out.println("THE ERROR " + errorMessge);
		return "login";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		Student user = new Student();
		model.addAttribute("userform", user);
		return "addStudent";
	}

	@RequestMapping("/showStudent")
	public String showStudent(Model model) {

		List<Student> studentList = userService.getUser();
		model.addAttribute("users", studentList);
		return "showStudent";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String doLogin(@ModelAttribute("userform") @Validated Student user,
			BindingResult result, Model model) {
		System.out.println("I am here in do login");
		if (result.hasErrors()) {
			System.out.println("Error present");
			return "addStudent";
		}

		model.addAttribute("student", user);
		try {
			userService.createUser(user);
		} catch (Exception e) {
			model.addAttribute("error",
					"Please Choose  different Email and try again");
			return "index";
		}

		return "detail";
	}

	@RequestMapping(value = "/userread", method = RequestMethod.GET)
	public String doReadUser(Model model) {
		return "readuser";
	}

	@RequestMapping(value = "/userupdate", method = RequestMethod.GET)
	public String doWriteUser(Model model) {
		return "updateuser";
	}

	@RequestMapping(value = "/adminread", method = RequestMethod.GET)
	public String doReadAdmin(Model model) {
		return "admincrud";
	}

}