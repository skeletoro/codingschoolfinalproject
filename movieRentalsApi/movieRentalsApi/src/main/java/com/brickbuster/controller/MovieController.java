package com.brickbuster.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brickbuster.entity.Movie;
import com.brickbuster.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private MovieService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Object>(service.createMovie(movie), HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getMovies() {
		return new ResponseEntity<Object>(service.getMovies(), HttpStatus.OK);

	}

	@RequestMapping(value = "/{movieId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable Long movieId) {
		try {
			return new ResponseEntity<Object>(service.updateMovie(movie, movieId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update movie.", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMovie(@PathVariable Long movieId) {
		try {
			service.removeMovie(movieId);
			return new ResponseEntity<Object>("Successfully deleted movie with id: " + movieId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete movie.", HttpStatus.BAD_REQUEST);
		}
	}
}
