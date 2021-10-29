package com.adobe;

import java.util.Collection;

public class MovieDTO {
	 private Long id;
	    private String title;
	    private String poster;
	    private Collection<MovieReview> reviews;

	    
	    public MovieDTO() {
		}


		public MovieDTO(Movie movie, Collection<MovieReview> reviews) {
	        this.id = movie.getId();
	        this.title = movie.getTitle();
	        this.poster = movie.getPoster();
	        this.reviews = reviews;
	    }


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getPoster() {
			return poster;
		}


		public void setPoster(String poster) {
			this.poster = poster;
		}


		public Collection<MovieReview> getReviews() {
			return reviews;
		}


		public void setReviews(Collection<MovieReview> reviews) {
			this.reviews = reviews;
		}
		
}
