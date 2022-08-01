package com.revature.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@ComponentScan("com.revature.ecommerce")
public class Project02EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project02EcomAppApplication.class, args);
	}

}
