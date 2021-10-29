package com.adobe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MovieReview {
    @Id
    @GeneratedValue
    private Long Id;
    private Long movieId;
    private String review;
    private String authorName;
	public MovieReview() {
	}
	public MovieReview(Long id, Long movieId, String review, String authorName) {
		Id = id;
		this.movieId = movieId;
		this.review = review;
		this.authorName = authorName;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
    
    
}