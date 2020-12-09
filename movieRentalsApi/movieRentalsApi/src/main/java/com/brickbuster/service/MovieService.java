package com.brickbuster.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.Movie;
import com.brickbuster.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger logger = LogManager.getLogger(MovieService.class);

	@Autowired
	private MovieRepository repo;

	public Movie createMovie(Movie movie) {
		return repo.save(movie);

	}

	public Iterable<Movie> getMovies() {
		return repo.findAll();

	}

	public Movie updateMovie(Movie movie, Long movieId) throws Exception {
		try {
			Movie romanceMovie = repo.findById(movieId).get();
			romanceMovie.setMovieId(movie.getMovieId());
			romanceMovie.setTitle(movie.getTitle());
			romanceMovie.setPrice(movie.getPrice());
			return repo.save(romanceMovie);
		} catch (Exception e) {
			logger.error("Exception occured while tring to update movie: " + movieId, e);
			throw new Exception("Unable to update movie.");
		}

	}

	public void removeMovie(Long movieId) throws Exception {
		try {
			repo.deleteById(movieId);

		} catch (Exception e) {
			logger.error("Exception occured while trying to delete movie: " + movieId, e);
			throw new Exception("Unable to delete movie.");
		}
	}

}
