package com.yassine.gamess.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yassine.gamess.entities.Game;

public interface GameService {

	Game saveGame(Game g);

	Game updateGame(Game g);

	void deleteGame(Game g);

	void deleteGameById(Long id);

	Game getGame(Long id);

	List<Game> getAllGames();

	Page<Game> getAllGamesParPage(int page, int size);

}
