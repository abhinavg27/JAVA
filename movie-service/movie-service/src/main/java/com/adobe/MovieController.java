package com.adobe;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewClient reviewClient;

	@GetMapping("/{movieID}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable("movieID") Long movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new EntityNotFoundException("Movie not found"));
		CollectionModel<MovieReview> movieReviews = reviewClient.getMovieReviews(movieId);
		return ResponseEntity.ok(new MovieDTO(movie, movieReviews.getContent()));
	}
}
