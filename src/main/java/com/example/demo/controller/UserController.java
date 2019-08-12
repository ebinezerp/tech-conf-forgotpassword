package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ForgetPasswordEmail;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ForgetPasswordEmail forgetPasswordMail;

	@GetMapping("/")
	public String registrationPage(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Errors errors, Model model) {

		if (errors.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}

		if (userService.save(user) == null) {
			model.addAttribute("errorMessage", "Internal Error Try Again");
			return "register";
		}

		return "redirect:/login";

	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		User user = userService.login(username, password);

		if (user == null) {
			model.addAttribute("errorMessage", "Invalid Credentials");
		}

		model.addAttribute("user", user);
		return "display";
	}

	@GetMapping("/forgetpassword")
	public String forgetPassword(Model model) {
		return "forgetpassword";
	}

	@PostMapping("/forgetpassword")
	public String forgetPasswordProcess(@RequestParam("username")String username,Model model,HttpServletRequest request) {
		
		
		System.out.println(username);
		
		User user = userService.get(username);
		
		if(user == null) {
			model.addAttribute("errorMessage", "Username is not existed");
			return "forgetpassword";
		}
		
		
		forgetPasswordMail.send(user.getEmail(), user.getPassword(), "http://" + request.getServerName() + ":" + request.getServerPort());
		return "redirect:/login";
		
	}

}
