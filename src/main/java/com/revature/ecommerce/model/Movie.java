package com.revature.ecommerce.model;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;//Primary Key
	
	private String title;
	private String description;
	private String genre;
	private Year releaseYear;
	private float price;
	private float rating;
	private int inStock;
	private String movieCoverLink;
	
	@OneToMany(mappedBy = "movie")
	private Set<Transaction> transactions = new HashSet<>();
	

	public Movie(String title, String description, String genre, Year releaseYear, float price,
			float rating, int inStock, String movieCoverLink) {
		super();
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.price = price;
		this.rating = rating;
		this.inStock = inStock;
		this.movieCoverLink = movieCoverLink;
	}

	
	
}
