package com.yassine.gamess.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.entities.Genre;

public interface GameService {

	Game saveGame(Game g);

	Game updateGame(Game g);

	void deleteGame(Game g);

	void deleteGameById(Long id);

	Game getGame(Long id);

	List<Game> getAllGames();

	Page<Game> getAllGamesParPage(int page, int size);

	List<Game> findByNomGame(String nom);

	List<Game> findByNomGameContains(String nom);

	List<Game> findByNomPrix(String nom, Double prix);

	List<Game> findByGenre(Genre genre);

	List<Game> findByGenreIdGenre(Long id);

	List<Game> findByOrderByNomGameAsc();

	List<Game> trierGamesNomsPrix();

	List<Genre> getAllGenres();
	
}
