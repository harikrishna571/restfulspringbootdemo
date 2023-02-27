package com.demo.sb.restdemo.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sb.restdemo.beans.User;
import com.demo.sb.restdemo.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private MessageSource msg;	
	
	//@Value(na)
	//String nsgValue;
	
	public UserController(MessageSource msg) {
		this.msg = msg;
	}

	@Autowired
	UserService userSerice;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userSerice.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getAllUsers(@PathVariable int id){
		return userSerice.getUserById(id);
	}
	
	/*
	 * @PostMapping("/users") public void addUser(@Valid @RequestBody User user){
	 * userSerice.addUser(user); }
	 */
	
	/* after adding the user send the proper respone*/
	@PostMapping("/users")
	public ResponseEntity<User> AddUserRes(@Valid @RequestBody User user){
		
		userSerice.addUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteByUserId(@PathVariable int id){
		return userSerice.deleteUserById(id);
	}
	
	/* for Internationalization - I18N*/
	@GetMapping("/message")
	public String getMsg() {		
		Locale locale=LocaleContextHolder.getLocale();
		return msg.getMessage("good.morning.message", null, "Default message", locale);
	}
}
