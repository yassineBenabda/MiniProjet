package com.yassine.gamess.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yassine.gamess.entities.Game;
import com.yassine.gamess.service.GameService;

@Controller
public class GameController {
	@Autowired
	GameService gameService;

	@RequestMapping("/ListeGames")
	public String listeGames(ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Game> games = gameService.getAllGamesParPage(page, size);
		modelMap.addAttribute("games", games);
		modelMap.addAttribute("pages", new int[games.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeGames";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createGame";
	}

	@RequestMapping("/saveGame")
	public String saveGame(@ModelAttribute("game") Game game, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		game.setDatedeSortie(dateCreation);

		Game saveGame = gameService.saveGame(game);
		String msg = "game enregistré avec Id " + saveGame.getIdGame();
		modelMap.addAttribute("msg", msg);
		return "createGame";
	}

	@RequestMapping("/supprimerGame")
	public String supprimerGame(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		gameService.deleteGameById(id);
		Page<Game> games = gameService.getAllGamesParPage(page, size);
		modelMap.addAttribute("games", games);
		modelMap.addAttribute("pages", new int[games.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeGames";
	}

	@RequestMapping("/modifierGame")
	public String editerGame(@RequestParam("id") Long id, ModelMap modelMap) {
		Game g = gameService.getGame(id);
		modelMap.addAttribute("game", g);
		return "editerGame";
	}

	@RequestMapping("/updateGame")
	public String updateGame(@ModelAttribute("produit") Game game, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		game.setDatedeSortie(dateCreation);

		gameService.updateGame(game);
		List<Game> games = gameService.getAllGames();
		modelMap.addAttribute("games", games);
		return "listeGames";
	}
}
