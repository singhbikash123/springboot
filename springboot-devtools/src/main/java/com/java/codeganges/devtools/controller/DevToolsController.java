package com.java.codeganges.devtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevToolsController {
	
	@GetMapping("/")
	public String getDevTools() {
		return "DevTools Configuration";
	}

}
