package com.revature.ecommerce.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","transactions"})
@Table(name="Movie_HM")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//Primary Key
	
	
	private String title;
	private String description;
	private String genre;
	private int releaseYear;
	private double price;
	private double rating;
	private int inStock;
	private String movieCoverLink;
	

	public Movie(String title, String description, String genre, int year, double price,
			double rating, int inStock, String movieCoverLink) {
		super();
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = year;
		this.price = price;
		this.rating = rating;
		this.inStock = inStock;
		this.movieCoverLink = movieCoverLink;
	}

	
	
}
