package com.spring.starter.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.spring.starter.models.User;
import com.spring.starter.repository.UserRepository;

@Service
public class UserService {
	

	@Autowired
	UserRepository userRepository;
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<User> getAllUsers(){
		return userRepository.findAll();
	} 
	
	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}
	
	@Secured("ROLE_ADMIN")
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<User> deleteUser(String id) {
		Optional<User> user = getUser(id); 
		userRepository.deleteById(id);
		return user;
	}

}
