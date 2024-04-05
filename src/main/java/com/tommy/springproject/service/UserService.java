package com.tommy.springproject.service;

import com.tommy.springproject.model.User;

public interface UserService {

	void  userSignUp(User user);
	User userLogin(String email,String psw);
}
