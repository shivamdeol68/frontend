package com.socialm.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialm.entity.User;
import com.socialm.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		user.setRoles(Set.of("ROLE_USER"));
		return userService.saveUser(user);
	}
	
	@GetMapping("/{username}")
	public User getByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
}
