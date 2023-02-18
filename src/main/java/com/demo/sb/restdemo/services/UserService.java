package com.demo.sb.restdemo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.sb.restdemo.beans.User;

@Service
public class UserService {

	static ArrayList<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Revi", LocalDate.now().minusYears(30)));
		users.add(new User(2, "kevi", LocalDate.now().minusYears(32)));
	}

	public List<User> getUsers() {
		return users;
	}
}
