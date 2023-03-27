package com.demo.sb.restdemo.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sb.restdemo.beans.Post;
import com.demo.sb.restdemo.beans.User;
import com.demo.sb.restdemo.jpa.PostRepository;
import com.demo.sb.restdemo.jpa.UserRepository;
import com.demo.sb.restdemo.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {
	
	private MessageSource msg;	
	
	//@Value(na)
	//String nsgValue;
	
	public UserJpaController(MessageSource msg) {
		this.msg = msg;
	}

	@Autowired
	UserService userSerice;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> getAllUsers(@PathVariable int id){
		return userRepository.findById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getpostsForUser(@PathVariable int id) throws UserPrincipalNotFoundException{
		Optional<User> user =userRepository.findById(id);
		if(user.isEmpty())
			throw new UserPrincipalNotFoundException(getMsg());
		
		return user.get().getPosts();
		
	}
	
	/*
	 * @PostMapping("/users") public void addUser(@Valid @RequestBody User user){
	 * userSerice.addUser(user); }
	 */
	
	/* after adding the user send the proper respone*/
	@PostMapping("/jpa/users")
	public ResponseEntity<User> AddUserRes(@Valid @RequestBody User user){
		
		userSerice.addUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public void AddPostForUser(@PathVariable int id,@Valid @RequestBody Post post) throws UserPrincipalNotFoundException{
		Optional<User> user = userRepository.findById(id);
			if(user.isEmpty())
				throw new UserPrincipalNotFoundException(getMsg());
		
			post.setUser(user.get());
		postRepository.save(post);
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteByUserId(@PathVariable int id){
		userRepository.deleteById(id);
	}
	
	/* for Internationalization - I18N*/
	@GetMapping("/jpa/message")
	public String getMsg() {		
		Locale locale=LocaleContextHolder.getLocale();
		return msg.getMessage("good.morning.message", null, "Default message", locale);
	}
}
