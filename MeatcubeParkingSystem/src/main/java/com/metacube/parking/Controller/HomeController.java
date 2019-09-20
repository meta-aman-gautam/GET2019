package com.metacube.parking.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Employee;
import com.metacube.parking.model.Login;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;
import com.metacube.parking.service.ParkingService;

/**
 * The Home controller the is layer which is mapped to the
 * view layer and handles all the Request from the url
 *  
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 *
 */
@Controller
public class HomeController {
	
	ParkingService service = new ParkingService();

	/**
	 * This method redirect to index page.
	 *
	 * @param model 
	 * @return String 
	 */
	@GetMapping("/index")
	public String goToIndexPage(Model model) {
		Employee employee = new Employee();
		model.addAttribute(employee);
		return "Registration";

	}

	/**
	 * Method to adds the employee in the database.
	 *
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @param session 
	 * @return string
	 */
	@PostMapping("/addEmployee")
	public String addEmployee(@Validated @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model model, HttpSession session) {

		String answer;
		if (bindingResult.hasErrors()) {
			answer= "Registration";
		}
		if (!employee.getPassword().equals(employee.getConfirmPassword())) {
			FieldError error = new FieldError("confirmPassword", "confirmPassword", "Password and Confirm Password should be same");
			System.out.println(error);
			bindingResult.addError(error);
			answer= "Registration";
		} else {
			try {
				employee.setProfilePhtotoUrl("/images/default.jpg");
				service.addEmployee(employee);
			} catch (SQLIntegrityConstraintViolationException e) {
				FieldError error = new FieldError("email", "email", "Email Already in use");
				bindingResult.addError(error);
				answer= "Registration";
			}
			Vehicle vehicle = new Vehicle();
			model.addAttribute(vehicle);
			session.setAttribute("Email", employee.getEmail());
			answer= "Vehicle";
		}
		return answer;
	}

	/**
	 * Adds the vehicle details in the database.
	 *
	 * @param vehicle
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return string
	 */
	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,BindingResult bindingResult, Model model, HttpSession session) {
		String answer ;
		if (bindingResult.hasErrors()) {
			answer= "Vehicle";
		} else {
			service.addVehicle(vehicle, (String) session.getAttribute("Email"));
			Plan plan = new Plan();
			model.addAttribute(plan);
			session.setAttribute("VehicleId", service.getVehicleId((String) session.getAttribute("Email")));
			session.setAttribute("Type", vehicle.getVehicleType());
			answer= "Plan";
		}
		return answer;
	}

	/**
	 * Adds the plan for the user to choose from .
	 *
	 * @param plan
	 * @param bindingResult 
	 * @param model
	 * @param session
	 * @param request
	 * @return string
	 */
	@PostMapping("/addPlan")
	public String addPlan(@Valid @ModelAttribute("plan") Plan plan,BindingResult bindingResult, Model model, HttpSession session,HttpServletRequest request) {
		String answer;
		if (bindingResult.hasErrors()) {
			answer= "Error";
		} else {
			plan.setCurrency(request.getParameter("CurrencySelect"));
			plan.setPrice(request.getParameter("TotalCost"));
			service.addPlan(plan, (String) session.getAttribute("Email"),(int) session.getAttribute("VehicleId"));
			Login login = new Login();
			model.addAttribute(login);
			answer= "Login";
		}
		return answer;
	}

	/**
	 * GET Mapping of the URL Login page.
	 *
	 * @param model the model
	 * @return string
	 */
	@GetMapping("/login")
	public String loginPage(Model model) {
		Login login = new Login();
		model.addAttribute(login);
		return "Login";
	}

	/**
	 * Post mapping of the URL Login.
	 *
	 * @param login
	 * @param bindingResult 
	 * @param model 
	 * @param session 
	 * @return string
	 */
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model, HttpSession session) {
		String answer ="Login";
		if (!bindingResult.hasErrors()) {
			if (service.checkAuthentication(login.getEmail(), login.getPassword())) {
				session.setAttribute("Email", login.getEmail());
				session.setAttribute("ProfilePhotoUrl", service.getPhotoUrl(login.getEmail()));
				session.setAttribute("Name", service.getName(login.getEmail()));
				session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
				session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
				answer= "Home";
			}
		}
		return answer;
	}

	/**
	 * Update profile photo in the database.
	 *
	 * @param file the file
	 * @param req the req
	 * @param session the session
	 * @return string
	 */
	@PostMapping("/updateProfilePhoto")
	public String updateProfilePhoto(@RequestParam("PhotoUrl") MultipartFile file,HttpServletRequest req, HttpSession session) {
		service.updatePhotoUrl("/images/" + file.getOriginalFilename(),(String) session.getAttribute("Email"));
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get("C:\\EAD spring\\MeatcubeParkingSystem\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
			Files.write(path, bytes);
			session.setAttribute("ProfilePhotoUrl", service.getPhotoUrl((String) session.getAttribute("Email")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Home";
	}


	/**
	 * Profile photo is mapped to the profile photo jsp page.
	 *
	 * @return the string
	 */
	@GetMapping("/profilePhoto")
	public String profilePhoto() {
		return "ProfilePhoto";
	}

	/**
	 * Friends method is mapped to the Show Friends Page.
	 *
	 * @return the string
	 */
	@GetMapping("/friends")
	public String friends() {
		return "Friends";
	}

	/**
	 * Profile method is mapped to the setting up the profile.
	 *
	 * @param req 
	 * @param session 
	 * @return string
	 */
	@PostMapping("/profile")
	public String profile(HttpServletRequest req, HttpSession session) {
		String email = (String) req.getParameter("EmailId");
		if (email.equals(session.getAttribute("Email"))) {
			session.setAttribute("Profile", session.getAttribute("UserProfile"));
			session.setAttribute("IsUser", true);
		} else
			session.setAttribute("Profile", service.getUserProfile(email));
		return "Profile";
	}

	/**
	 * Updates the user profile to the database.
	 *
	 * @param session the session
	 * @param model the model
	 * @return string
	 */
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		dtoEmployee dtoEmployee = (dtoEmployee) session.getAttribute("UserProfile");
		model.addAttribute(dtoEmployee);
		return "Update";
	}

	/**
	 * Home.
	 *
	 * @param session the session
	 * @return string
	 */
	@GetMapping("/home")
	public String home(HttpSession session) {
		session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
		session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
		return "Home";
	}

	/**
	 * Details update method is mapped to the update details in the page.
	 *
	 * @param dtoEmployee
	 * @param bindingResult 
	 * @param model 
	 * @param session 
	 * @return string
	 */
	@PostMapping("/detailsUpdate")
	public String detailsUpdate(@Valid @ModelAttribute("dtoEmployee") dtoEmployee dtoEmployee,BindingResult bindingResult, Model model, HttpSession session) {

		String answer;
		if (bindingResult.hasErrors()) {
			answer= "Update";
		} else {
			service.updateEmployee((String) session.getAttribute("Email"), dtoEmployee);
			session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
			session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
			answer= "Home";
		}
		return answer;
	}

	/**
	 * Logout is mapped to logout of the session.
	 *
	 * @param session
	 * @param model
	 * @return string
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		Login login = new Login();
		model.addAttribute(login);
		session.invalidate();
		return "Login";
	}
}