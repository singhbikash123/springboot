package com.java.codeganges.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String getHelloWorld() {
		
		return "SpringBoot Hello World!!";
	}

}
