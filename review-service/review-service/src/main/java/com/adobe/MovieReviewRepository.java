package com.adobe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reviews", collectionResourceRel = "reviews")
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

    List<MovieReview> findAllByMovieId(Long movieID);
}