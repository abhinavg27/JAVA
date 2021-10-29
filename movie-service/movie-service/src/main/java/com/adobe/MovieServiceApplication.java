package com.adobe;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	 @Bean
	    ApplicationRunner initReviews(MovieRepository movieRepository) {
	        return args -> {
	            Movie lordOfTheRings = new Movie();
	            lordOfTheRings.setTitle("The Lord Of The Rings: The Return of the King");
	            lordOfTheRings.setPoster("https://resizing.flixster.com/0HK1Y-onFu90kMEV1KfRbs7-WGE=/206x305/v1.bTsxMTE2NjQyMztqOzE4NDQ0OzEyMDA7ODAwOzEyMDA");
	            movieRepository.save(lordOfTheRings);

	            Movie theLastSamurai = new Movie();
	            theLastSamurai.setTitle("The Last Samurai");
	            theLastSamurai.setPoster("https://resizing.flixster.com/bJPMRIGxIceRp965aQ6Htekf-xM=/206x305/v1.bTsxMTE2Njg2MTtqOzE4NDQ0OzEyMDA7ODAwOzEyMDA");
	            movieRepository.save(theLastSamurai);

	            movieRepository.findAll().forEach(System.out::println);
	        };
	    }
}
