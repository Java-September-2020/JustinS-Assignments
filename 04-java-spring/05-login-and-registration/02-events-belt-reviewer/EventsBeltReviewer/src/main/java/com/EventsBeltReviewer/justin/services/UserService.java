package com.EventsBeltReviewer.justin.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventsBeltReviewer.justin.models.User;
import com.EventsBeltReviewer.justin.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository UserRepo;
	
	public User findUser(Long id) {
		User user = this.UserRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> allUsers(){
		return this.UserRepo.findAll();
	}
	
	public User registerNewUser(User nUser) {
		String hash = BCrypt.hashpw(nUser.getPassword(), BCrypt.gensalt());
		nUser.setPassword(hash);
		return this.UserRepo.save(nUser);
	}
	
	public boolean authUser(String email, String password) {
		User authUser = this.UserRepo.findByEmail(email);
		if(authUser == null) {
			return false;
		}
		return BCrypt.checkpw(password, authUser.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.UserRepo.findByEmail(email);
	}
	
}
