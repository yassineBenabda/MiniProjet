package com.yassine.gamess;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.repos.GameRepository;
import com.yassine.gamess.service.GameService;

@SpringBootTest
class GamessApplicationTests {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameService gameService;

	@Test
	public void testCreateGame() {
		Game game = new Game("nba", 22.500, new Date());
		gameRepository.save(game);
	}

	@Test
	public void testFindGame() {
		Game g = gameRepository.findById(1L).get();
		System.out.println(g);
	}

	@Test
	public void testUpdateGame() {
		Game g = gameRepository.findById(1L).get();
		g.setPrixGame(1000.0);
		gameRepository.save(g);
	}

	@Test
	public void testDeleteGame() {
		gameRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousGames() {
		List<Game> game = gameRepository.findAll();
		for (Game g : game) {
			System.out.println(g);
		}
	}

	@Test
	public void testFindByNomGameContains() {
		Page<Game> games = gameService.getAllGamesParPage(0, 2);
		System.out.println(games.getSize());
		System.out.println(games.getTotalElements());
		System.out.println(games.getTotalPages());
		games.getContent().forEach(g -> {
			System.out.println(g.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}
}
