package com.demo.sb.restdemo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.demo.sb.restdemo.beans.User;

@Service
public class UserService {

	static ArrayList<User> users = new ArrayList<>();
	static int userid=0;

	static {
		//users.add(new User(++userid, "Revi", LocalDate.now().minusYears(30)));
		//users.add(new User(++userid, "kevi", LocalDate.now().minusYears(32)));
	}

	public List<User> getUsers() {
		return users;
	}
	
	public User getUserById(int id) {
		Predicate<User> predicate= user->user.getId().equals(id);
		User user = users.stream().filter(predicate).findFirst().get();
		// User user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}
	
	public void addUser(User user) {
		user.setId(++userid);
		users.add(user);		
	}
	
	public User deleteUserById(int id) {
		Predicate<User> predicate= user->user.getId().equals(id);
		/*
		 * User user = users.stream().filter(predicate).findFirst().get();
		 * User user = users.stream().filter(predicate).findFirst().orElse(null);
		 * users.remove(user);
		 */
		
		users.removeIf(predicate);
		User user = users.stream().filter(predicate).findFirst().orElse(null); //it is just for returning purpose
		return user;
	}
}
