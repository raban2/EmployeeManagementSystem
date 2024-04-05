package com.tommy.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommy.springproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 User findByEmailAndPassword(String email, String psw);   //used for the login
}
