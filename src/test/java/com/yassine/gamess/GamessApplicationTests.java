package com.yassine.gamess;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.entities.Genre;
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

//	@Test
//	public void testFindByNomGameContains() {
//		Page<Game> games = gameService.getAllGamesParPage(0, 2);
//		System.out.println(games.getSize());
//		System.out.println(games.getTotalElements());
//		System.out.println(games.getTotalPages());
//		games.getContent().forEach(g -> {
//			System.out.println(g.toString());
//		});
//		/*
//		 * ou bien for (Produit p : prods) { System.out.println(p); }
//		 */
//	}

	@Test
	public void testFindGameByNom() {
		List<Game> gams = gameRepository.findByNomGame("madmax");
		for (Game g : gams) {
			System.out.println(g);
		}
	}

	@Test
	public void testFindGameByNomContains() {
		List<Game> gams = gameRepository.findByNomGameContains("mad");
		for (Game g : gams) {
			System.out.println(g);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Game> gams = gameRepository.findByNomPrix("madmax", 1.0);
		for (Game g : gams) {
			System.out.println(g);
		}
	}

	@Test
	public void testfindByGenre() {
		Genre gen = new Genre();
		gen.setIdGen(2L);
		List<Game> gams = gameRepository.findByGenre(gen);
		for (Game g : gams) {
			System.out.println(g);
		}
	}

	@Test
	public void findByGenreIdGen() {
		List<Game> gams = gameRepository.findByGenreIdGen(2L);
		for (Game g : gams) {
			System.out.println(g);
		}
	}
	
	@Test
	public void testfindByOrderByNomGameAsc()
	{
	List<Game>  gams =  gameRepository.findByOrderByNomGameAsc();	 
		for (Game g : gams)
		{
			System.out.println(g);
		}
	 }
	
	@Test
	public void testTrierGamesNomsPrix() {
	List<Game>  gams = gameRepository.trierGamesNomsPrix();	 
		for (Game g : gams)
		{
			System.out.println(g);
		}
	}

}
