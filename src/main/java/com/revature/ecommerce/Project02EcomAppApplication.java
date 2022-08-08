package com.revature.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
public class Project02EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project02EcomAppApplication.class, args);
	}

}
