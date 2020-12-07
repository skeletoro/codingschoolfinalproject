package com.brickbuster.repository;

import org.springframework.data.repository.CrudRepository;

import com.brickbuster.entity.VideoGame;

public interface VideoGameRepository extends CrudRepository<VideoGame, Long>{

}
