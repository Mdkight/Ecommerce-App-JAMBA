package com.revature.ecommerce.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.exception.NoResourceFoundException;
import com.revature.ecommerce.model.Movie;
import com.revature.ecommerce.repository.MovieRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jamba/movie")
public class MovieController {
	MovieRepository movieRepository;

	
	@PostMapping("/new")
	public Movie addNewMovie(Movie newMovie) {
		if (newMovie!=null) {
		return movieRepository.save(newMovie);
		}else {   
			System.out.println("Not a valid entry (Entry may be null)");
			return null;
		}
	}
	
	
	@RequestMapping("/{title}")
	public ResponseEntity<Movie> getIndividualMovie(@PathVariable(value = "title") String movieTitle) throws NoResourceFoundException{
		Movie movie = movieRepository.findByTitle(movieTitle).orElseThrow(() -> new NoResourceFoundException("No Movie by that Title Found"));
		return ResponseEntity.ok().body(movie);
	}
	
	
	@GetMapping("/page_{num}")
	public ResponseEntity<Page<Movie>> getAllMovies(@PathVariable(value = "num") Integer num){
		Pageable firstPageWithTenElements; 
		firstPageWithTenElements = PageRequest.of(num-1, 10, Sort.by("title"));
		
		return ResponseEntity.ok().body(movieRepository.findAll(firstPageWithTenElements));
	}
	
	
	
	//TODO make sure cart controller gets movie prices
	//TODO Make sure Transaction controller has add movie to transaction and update movie quantity


}
