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
import org.springframework.web.bind.annotation.RestController;

import com.yassine.gamess.dto.GameDTO;
import com.yassine.gamess.entities.Game;
import com.yassine.gamess.service.GameService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class GameRESTConroller {
	
	@Autowired
	GameService gameService;
	
	@GetMapping
	List<GameDTO> getAllGames() {
		return gameService.getAllGames();
	}
	
	@GetMapping("/{id}")
	public GameDTO getGameById(@PathVariable("id") Long id) {
		return gameService.getGame(id);
	}
	
	@PostMapping("/addgame")
	public GameDTO createGame(@RequestBody GameDTO gameDTO) {
		return gameService.saveGame(gameDTO);
	}
	
	@PutMapping("/updategame")
	public GameDTO updateGame(@RequestBody GameDTO gameDTO) {
		return gameService.updateGame(gameDTO);
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