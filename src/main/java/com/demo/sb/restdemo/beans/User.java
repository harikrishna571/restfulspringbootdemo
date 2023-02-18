package com.demo.sb.restdemo.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private int id;
	private String name;
	private LocalDate dob;
	
}
