package com.demo.sb.restdemo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private LocalDateTime timestamp;
	private String msg;
	private String details;
	
}
