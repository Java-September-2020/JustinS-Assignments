package com.EventsBeltReviewer.justin.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.EventsBeltReviewer.justin.models.User;
import com.EventsBeltReviewer.justin.services.UserService;
import com.EventsBeltReviewer.justin.validations.UserValidator;


@Controller
public class HomeController {
		@Autowired
		private UserService userService;
		@Autowired
		private UserValidator validate;
	
	
		//landing.....landing :D
		@RequestMapping("/")
		public String landing(@ModelAttribute("user") User user) {
			return "landing.jsp";
		}
		
		//posting and validating user registration, then redirecting to dashboard
		@PostMapping("/register")
		public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
			validate.validate(newUser, result);
			if(result.hasErrors()) {
				return "landing.jsp";
			}
			User user = this.userService.registerNewUser(newUser);
			session.setAttribute("user_id", user.getId());
			return "redirect:/events";
		}
		
		//posting and validating user login with unique validations, then redirecting to dashboard
		@PostMapping("/login")
		public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs) {
			if(!this.userService.authUser(email, password)) {
				redirectAttrs.addFlashAttribute("loginError", "Invalid Email or Password");
				return "redirect:/landing";
			}
			User user = this.userService.getByEmail(email);
			session.setAttribute("user_id", user.getId());
			return "redirect:/events";
					
		}

		//logout through  session invalidation
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect/";
		}
}
