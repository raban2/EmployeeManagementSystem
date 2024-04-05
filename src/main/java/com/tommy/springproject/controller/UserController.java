package com.tommy.springproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tommy.springproject.model.User;
import com.tommy.springproject.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;


@Log   //It is also used for the Log4J annotation  which is handled by Lombok framework 
@Controller
@RequestMapping("/user") // request mapping and get mapping are same

/*
 * To request mapping is used to accesss this controller for eg i have too
 * access the login and signup form hence, the url for login will be =
 * user/login similarly for signup = user/signup
 */
public class UserController {
	
	//Log4J Framework
	//private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// used to open the login form
	@GetMapping("/login")
	public String getLogin() {
		return "LoginForm";
	}

	// used to open the signup form
	@GetMapping("signup")
	public String getSignup() {
		return "SignupForm";
	}

	// used to send the form data to the database
	@PostMapping("/signup")
	public String postSiqnup(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.userSignUp(user);
		return "LoginForm";
	}

	// used to send form data to query database
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model,HttpSession session) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes())); // encrypting password using md5
		User usr = userService.userLogin(user.getEmail(), user.getPassword()); // calling userLogin Method

		// checks whether usesr is not or not
		if (usr != null) {
			
			log.info("------user login success---------");
			session.setAttribute("validuser", usr);
			session.setMaxInactiveInterval(200); //session
			
			model.addAttribute("username" ,usr.getFname());
			return "Home"; // returning to home after login
		}
		// if user is null
		model.addAttribute("message", "User not Exist"); // setting error message to model
		return "LoginForm"; // returning to loginForm again

	}
	
	@GetMapping("/logout")
	public String logout( HttpSession session) {
		log.info("------Logout success-------");
		session.invalidate(); //session kill
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return "Profile";
	}

}
