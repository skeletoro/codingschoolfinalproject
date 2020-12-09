package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brickbuster.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{

}
