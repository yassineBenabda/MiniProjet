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

import com.yassine.gamess.dto.GameDTO;
import com.yassine.gamess.entities.Genre;
import com.yassine.gamess.service.GameService;

import jakarta.validation.Valid;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/ListeGames")
    public String listeGames(ModelMap modelMap,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<?> games = gameService.getAllGamesParPage(page, size);
        modelMap.addAttribute("games", games);
        modelMap.addAttribute("pages", new int[games.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeGames";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("gameDTO", new GameDTO());
        List<Genre> genres = gameService.getAllGenres();
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("genres", genres);
        return "formGame";
    }

    @RequestMapping("/saveGame")
    public String saveGame(@Valid @ModelAttribute("gameDTO") GameDTO gameDTO,
                           BindingResult bindingResult,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "2") int size) {
        if (bindingResult.hasErrors()) {
            return "formGame";
        }

        boolean isNew = (gameDTO.getIdGame() == null);
        gameService.saveGame(gameDTO);

        int currentPage = page;
        if (isNew) {
            Page<?> games = gameService.getAllGamesParPage(page, size);
            currentPage = games.getTotalPages() - 1;
        }

        return "redirect:/ListeGames?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerGame")
    public String supprimerGame(@RequestParam("id") Long id,
                                ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size) {
        gameService.deleteGameById(id);
        Page<?> games = gameService.getAllGamesParPage(page, size);
        modelMap.addAttribute("games", games);
        modelMap.addAttribute("pages", new int[games.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeGames";
    }

    @RequestMapping("/modifierGame")
    public String editerGame(@RequestParam("id") Long id,
                             ModelMap modelMap,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "2") int size) {
        GameDTO gameDTO = gameService.getGame(id);
        List<Genre> genres = gameService.getAllGenres();
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("gameDTO", gameDTO);
        modelMap.addAttribute("genres", genres);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formGame";
    }

    @RequestMapping("/updateGame")
    public String updateGame(@ModelAttribute("gameDTO") GameDTO gameDTO,
                             @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSortie = dateFormat.parse(date);
        gameDTO.setDatedeSortie(dateSortie);

        gameService.updateGame(gameDTO);

        List<GameDTO> games = gameService.getAllGames();
        modelMap.addAttribute("games", games);
        return "listeGames";
    }
}
