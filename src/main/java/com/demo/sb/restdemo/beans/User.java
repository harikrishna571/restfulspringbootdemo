package com.demo.sb.restdemo.beans;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private Integer id;
	
	@Size(min = 2)
	private String name;
	
	@Past
	private LocalDate dob;
	
}
