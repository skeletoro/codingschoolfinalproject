package com.brickbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brickbuster.entity.VideoGame;
import com.brickbuster.service.VideoGameService;

@RestController
@RequestMapping("/videoGames")
public class VideoGameController {

	@Autowired
	private VideoGameService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createVideoGame(@RequestBody VideoGame videoGame) {
		return new ResponseEntity<Object>(service.createVideoGame(videoGame), HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getVideoGame() {
		return new ResponseEntity<Object>(service.getVideoGame(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{videoGameId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateVideoGame(@RequestBody VideoGame videoGame, @PathVariable Long videoGameId) {
		try {
			return new ResponseEntity<Object>(service.updateVideoGame(videoGame, videoGameId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update videoGame.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{videoGameId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVideoGame(@PathVariable Long videoGameId) {
		try {
			service.removeVideoGame(videoGameId);
			return new ResponseEntity<Object>("Successfully deleted videoGame with id: " + videoGameId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete videoGame.", HttpStatus.BAD_REQUEST);
		}
	}
}
