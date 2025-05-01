package com.yassine.gamess.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yassine.gamess.dto.GameDTO;
import com.yassine.gamess.entities.Game;
import com.yassine.gamess.entities.Genre;

public interface GameService {

	GameDTO saveGame(GameDTO g);

	GameDTO updateGame(GameDTO g);

	GameDTO getGame(Long id);

	List<GameDTO> getAllGames();

	void deleteGame(Game g);

	void deleteGameById(Long id);

	Page<Game> getAllGamesParPage(int page, int size);

	List<Game> findByNomGame(String nom);

	List<Game> findByNomGameContains(String nom);

	List<Game> findByNomPrix(String nom, Double prix);

	List<Game> findByGenre(Genre genre);

	List<Game> findByGenreIdGenre(Long id);

	List<Game> findByOrderByNomGameAsc();

	List<Game> trierGamesNomsPrix();

	List<Genre> getAllGenres();

	GameDTO convertEntityToDto(Game g);

	Game convertDtoToEntity(GameDTO gameDto);

}