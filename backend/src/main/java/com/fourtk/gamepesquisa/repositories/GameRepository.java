package com.fourtk.gamepesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fourtk.gamepesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
