package com.yassine.gamess.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yassine.gamess.entities.Game;
import com.yassine.gamess.entities.Genre;
import com.yassine.gamess.service.GameService;

import jakarta.validation.Valid;

@Controller
public class GameController {
	@Autowired
	GameService gameService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/ListeGames")
	public String listeGames(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Game> games = gameService.getAllGamesParPage(page, size);
		modelMap.addAttribute("games", games);
		modelMap.addAttribute("pages", new int[games.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeGames";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("game", new Game());
		List<Genre> gen = gameService.getAllGenres();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("genres", gen);
		return "formGame";
	}

	@RequestMapping("/saveGame")
	public String saveProduit(@Valid Game game, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formGame";

		if (game.getIdGame() == null) // ajout
			isNew = true;

		gameService.saveGame(game);
		if (isNew) // ajout
		{
			Page<Game> games = gameService.getAllGamesParPage(page, size);
			currentPage = games.getTotalPages() - 1;
		} else // modif
			currentPage = page;

		// return "formProduit";
		return ("redirect:/ListeGames?page=" + currentPage + "&size=" + size);
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
	public String editerGame(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Game g = gameService.getGame(id);
		List<Genre> gen = gameService.getAllGenres();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("game", g);
		modelMap.addAttribute("genres", gen);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formGame";
	}

	@RequestMapping("/updateGame")
	public String updateGame(@ModelAttribute("game") Game game, @RequestParam("date") String date, ModelMap modelMap)
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
