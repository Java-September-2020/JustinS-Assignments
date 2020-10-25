package com.EventsBeltReviewer.justin.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.EventsBeltReviewer.justin.models.User;
import com.EventsBeltReviewer.justin.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository UserRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match, try again.");
		}
		
		if(this.UserRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "emailError", "This email has already been registered");
		}
		
		
	}
	
	
}
