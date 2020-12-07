package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
