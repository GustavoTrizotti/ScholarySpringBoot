package com.api.scholary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScholaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScholaryApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}

}
