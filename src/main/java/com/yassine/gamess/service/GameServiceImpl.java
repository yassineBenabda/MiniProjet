package com.yassine.gamess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.repos.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepository;

	@Override
	public Game saveGame(Game g) {
		return gameRepository.save(g);
	}

	@Override
	public Game updateGame(Game g) {
		return gameRepository.save(g);
	}

	@Override
	public void deleteGame(Game g) {
		gameRepository.delete(g);
	}

	@Override
	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}

	@Override
	public Game getGame(Long id) {
		return gameRepository.findById(id).get();
	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Page<Game> getAllGamesParPage(int page, int size) {
		return gameRepository.findAll(PageRequest.of(page, size));
	}
}
