package com.example.helloworld;

import com.example.provides.Greeter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ServiceLoader;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello() {
		Greeter greeter = ServiceLoader.load(Greeter.class)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Greeter provider not found"));
		return greeter.greet("World");
	}
}
