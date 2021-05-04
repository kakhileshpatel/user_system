package com.kakhileshpatel.user.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kakhileshpatel.user.system.model.User;
import com.kakhileshpatel.user.system.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User saveAddress(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
	
	@PutMapping("/user")
	public User updateAddress(@RequestBody User user) {
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getAllUsers(@PathVariable Long id){
		return userService.getUserById(id);
	}

}
