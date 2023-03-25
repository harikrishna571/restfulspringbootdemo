package com.demo.sb.restdemo.beans;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "User_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "name should be more than 2 characters")
	private String name;
	
	@Past
	private LocalDate dob;
	
}
