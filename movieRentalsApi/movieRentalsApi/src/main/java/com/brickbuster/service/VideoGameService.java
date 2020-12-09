package com.brickbuster.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickbuster.entity.VideoGame;
import com.brickbuster.repository.VideoGameRepository;

@Service
public class VideoGameService {

	private static final Logger logger = LogManager.getLogger(VideoGameService.class);

	@Autowired
	private VideoGameRepository repo;

	public VideoGame createVideoGame(VideoGame videoGame) {
		return repo.save(videoGame);

	}

	public Iterable<VideoGame> getVideoGame() {
		return repo.findAll();

	}

	public VideoGame updateVideoGame(VideoGame videoGame, Long videoGameId) throws Exception {
		try {
			VideoGame wowVideoGame = repo.findById(videoGameId).get();
			wowVideoGame.setVideoGameId(videoGame.getVideoGameId());
			wowVideoGame.setTitle(videoGame.getTitle());
			wowVideoGame.setPrice(videoGame.getPrice());
			return repo.save(wowVideoGame);
		} catch (Exception e) {
			logger.error("Exception occured while tring to update video game: " + videoGameId, e);
			throw new Exception("Unable to update video game.");
		}

	}

	public void removeVideoGame(Long videoGameId) throws Exception {
		try {
			repo.deleteById(videoGameId);

		} catch (Exception e) {
			logger.error("Exception occured while trying to delete video game: " + videoGameId, e);
			throw new Exception("Unable to delete video game.");
		}

	}
}
