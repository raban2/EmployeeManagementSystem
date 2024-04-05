package com.tommy.springproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommy.springproject.model.User;
import com.tommy.springproject.repository.UserRepository;
import com.tommy.springproject.service.UserService;

@Service   
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignUp(User user) {
		userRepo.save(user);
	}

	@Override
	public User userLogin(String email, String psw) {
		return userRepo.findByEmailAndPassword(email, psw);
		
	}
	
	
	
	
	
	
	

}
