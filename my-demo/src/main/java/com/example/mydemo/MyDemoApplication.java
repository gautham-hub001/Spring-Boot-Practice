package com.example.mydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyDemoApplication {

	public static void main(String[] args) {
		// Spring container initialization
		ConfigurableApplicationContext context = SpringApplication.run(MyDemoApplication.class, args);

		Alien a1 = context.getBean(Alien.class); // Dependency Injection
		a1.show();
		// Alien a2 = context.getBean(Alien.class); // Dependency Injection
		// a2.show();
		System.out.println("hellllo.........");
	}

}
