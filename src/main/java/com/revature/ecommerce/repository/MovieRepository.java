package com.revature.ecommerce.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
	public Optional<Movie> findByTitleContainingIgnoreCase(String title);
	
	
}
