package com.revature.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.revature.ecommerce.exception.NoResourceFoundException;
import com.revature.ecommerce.model.Movie;
import com.revature.ecommerce.repository.MovieRepository;

@RestController
@RequestMapping("/jamba/movie")
@EnableWebMvc
public class MovieController {

	MovieRepository movieRepository;

	
	@Autowired
	public MovieController(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@PostMapping("/new")
	public Movie addNewMovie(@RequestBody Movie newMovie) {	
		return  movieRepository.save(newMovie);
	}
	

	@PostMapping("/allnew")
	public List<Movie> addManyNewMovies(@RequestBody List<Movie> newMovies) {	
		return  movieRepository.saveAll(newMovies);
	}
	

	@RequestMapping("/{title}")
	public ResponseEntity<Movie> getIndividualMovie(@PathVariable("title") String movieTitle) throws NoResourceFoundException{ 
		movieTitle=String.join(" ",movieTitle.split("_"));
		Movie movie = movieRepository.findByTitleContainingIgnoreCase(movieTitle).orElseThrow(() -> new NoResourceFoundException("No Movie by that Title Found"));
		return ResponseEntity.ok().body(movie);
	}
	
	@GetMapping("/page_{num}")
	public ResponseEntity<Page<Movie>> getAllMoviesInPages(@PathVariable(value = "num") Integer num){
		Pageable nextPageWithTenElements; 
		nextPageWithTenElements = PageRequest.of(num-1, 10, Sort.by("title"));
		
		return ResponseEntity.ok(movieRepository.findAll(nextPageWithTenElements));
	}
	
	@GetMapping("/all-movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		return ResponseEntity.ok(movieRepository.findAll());
	}
}
