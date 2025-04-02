package com.yassine.gamess;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.service.GameService;

@SpringBootApplication
public class GamessApplication implements CommandLineRunner {

	@Autowired
	GameService gameService;

	public static void main(String[] args) {
		SpringApplication.run(GamessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gameService.saveGame(new Game("rdr2", 2600.0, new Date()));
		gameService.saveGame(new Game("madmax", 2800.0, new Date()));
		gameService.saveGame(new Game("minecraft", 900.0, new Date()));
	}

}
