package com.revature.ecommerce.client;

import org.springframework.web.client.RestTemplate;

import com.revature.ecommerce.model.Movie;

//can use for testing rest services before we have front end
public class RestClient {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		Movie m1 = new Movie("The Little Mermaid", "A mermaid princess makes a Faustian bargain in an attempt to become human and win a prince's love.", "Comedy", 1989, 3.99, 7.6, 32, "a very good link");
		
		Movie addedMovie = restTemplate.postForObject("http://LocalHost:8080/movie/new", m1, Movie.class);
		
	}
	
	

}
