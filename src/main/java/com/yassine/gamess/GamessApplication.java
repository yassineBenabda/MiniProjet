package com.yassine.gamess;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.yassine.gamess.entities.Game;
import com.yassine.gamess.service.UserService;

@SpringBootApplication
public class GamessApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(GamessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Game.class);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}