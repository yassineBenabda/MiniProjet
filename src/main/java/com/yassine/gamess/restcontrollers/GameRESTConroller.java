package com.yassine.gamess.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.service.GameService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class GameRESTConroller {
	
	@Autowired
	GameService gameService;
	
	@RequestMapping(method=RequestMethod.GET)
	List<Game> getAllGames() {
		return gameService.getAllGames();
	}
	
	@GetMapping("/{id}")
	public Game getGameById(@PathVariable("id") Long id) {
		return gameService.getGame(id);
	}
	
	@PostMapping("/addgame")
	public Game createGame(@RequestBody Game game) {
		return gameService.saveGame(game);
	}
	
	@PutMapping("/updategame")
	public Game updateGame(@RequestBody Game game) {
		return gameService.updateGame(game);
	}
	
	@DeleteMapping("/deletegame/{id}")
	public void deleteGame(@PathVariable("id") Long id) {
		gameService.deleteGameById(id);
	}
	
	@GetMapping("/gamesgenre/{idGen}")
	public List<Game> getGamesByGenreId(@PathVariable("idGen") Long idGen) {
		return gameService.findByGenreIdGenre(idGen);
	}
}
