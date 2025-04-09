package com.yassine.gamess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.yassine.gamess.entities.Game;

@SpringBootApplication
public class GamessApplication implements CommandLineRunner {

	//@Autowired
	//GameService gameService;
	
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	
	public static void main(String[] args) {
		SpringApplication.run(GamessApplication.class, args);
	}
	
	@Override 
	public void run(String... args) throws Exception { 
		repositoryRestConfiguration.exposeIdsFor(Game.class);
	//	gameService.saveGame(new Game("rdr2", 26.0, new Date()));
	//	gameService.saveGame(new Game("madmax", 28.0, new Date()));
	//	gameService.saveGame(new Game("minecraft", 90.0, new Date()));
	}
}
