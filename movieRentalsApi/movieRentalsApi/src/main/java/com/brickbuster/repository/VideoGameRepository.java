package com.brickbuster.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.brickbuster.entity.VideoGame;

@Repository
public interface VideoGameRepository extends CrudRepository<VideoGame, Long>{
	
	

}
