package com.md.it.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.md")
public class ItFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItFrameworkApplication.class, args);
	}

}
