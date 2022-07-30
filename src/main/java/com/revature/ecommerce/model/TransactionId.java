package com.revature.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
public class TransactionId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name = "cart_number")
	private Integer cartNumber;
	

}
