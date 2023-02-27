package com.demo.sb.restdemo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * types
 * 
 * URI - localhost:8080/v1/person, localhost:8080/v2/person
 * RequestParam - localhost:8080/person?version=1, localhost:8080/person?version=2
 * Header -   postman ==> x-api-key =1
 * MediaType - 
 * 
 * */
@RestController
public class VersionController {

	/*URI type starts here*/
	@GetMapping("/v1/person")
	public Person1 getV1PersionName() {
		return new Person1("James Pond");
	}
	
	@GetMapping("/v2/person")
	public Person2 getV2PersionName() {
		return new Person2(new Name("James","Pond"));
	}
	
	/*Request type starts here*/
	@GetMapping(path = "/person",params = "version=1")
	public Person1 getParamV1PersionName() {
		return new Person1("James Pond");
	}
	
	@GetMapping(path = "/person",params = "version=2")
	public Person2 getParamV2PersionName() {
		return new Person2(new Name("James","Pond"));
	}
	
	/*Header type starts here*/
	@GetMapping(path = "/person",headers = "x-api-key=1")
	public Person1 getHeaderV1PersionName() {
		return new Person1("James Pond");
	}
	
	@GetMapping(path = "/person",headers = "x-api-key=2")
	public Person2 getHeaderV2PersionName() {
		return new Person2(new Name("James","Pond"));
	}
	
	/*MediaType type starts here*/
	@GetMapping(path = "/person",produces =  "application/vnd.company.app-v1+json")
	public Person1 getMediarV1PersionName() {
		return new Person1("James Pond");
	}
	
	@GetMapping(path = "/person",produces = "application/vnd.company.app-v2+json")
	public Person2 getMediaV2PersionName() {
		return new Person2(new Name("James","Pond"));
	}
}
