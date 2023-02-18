package com.demo.sb.restdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sb.restdemo.beans.User;
import com.demo.sb.restdemo.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userSerice;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userSerice.getUsers();
	}
}
