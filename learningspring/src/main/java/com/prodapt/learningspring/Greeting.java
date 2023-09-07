package com.prodapt.learningspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

	@GetMapping("/greet")
	public String lis() {
		return "Greetings from Spring!";
	}
}