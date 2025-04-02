package com.yassine.gamess.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.gamess.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
