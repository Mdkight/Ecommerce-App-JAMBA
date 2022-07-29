package com.revature.ecommerce.model;

import java.time.Year;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MovieId;//Primary Key
	
	private String title;
	private String description;
	private String genre;
	private Year releaseYear;
	private float price;
	private float rating;
	private int inStock;
	private String movieCoverLink;
	
	public Movie() {
		super();
	}

	public Movie(int movieId, String title, String description, String genre, Year releaseYear, float price,
			float rating, int inStock, String movieCoverLink) {
		super();
		MovieId = movieId;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.price = price;
		this.rating = rating;
		this.inStock = inStock;
		this.movieCoverLink = movieCoverLink;
	}

	public int getMovieId() {
		return MovieId;
	}
	public void setMovieId(int movieId) {
		MovieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Year getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Year releaseYear) {
		this.releaseYear = releaseYear;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public String getMovieCoverLink() {
		return movieCoverLink;
	}

	public void setMovieCoverLink(String movieCoverLink) {
		this.movieCoverLink = movieCoverLink;
	}

	@Override
	public String toString() {
		return "Movie [MovieId=" + MovieId + ", title=" + title + ", description=" + description + ", genre=" + genre
				+ ", releaseYear=" + releaseYear + ", price=" + price + ", rating=" + rating + ", inStock=" + inStock + "]";
	}
	
	
	
}
