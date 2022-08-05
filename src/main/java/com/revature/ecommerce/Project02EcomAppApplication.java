package com.revature.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.revature.ecommerce") // that was the whole conversation we just had earlier lol. @SpringBootApplication handles this for us, and defaults to the package that it's in
public class Project02EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project02EcomAppApplication.class, args);
	}

}
