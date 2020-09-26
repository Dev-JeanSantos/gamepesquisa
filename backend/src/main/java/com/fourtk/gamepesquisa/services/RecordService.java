package com.fourtk.gamepesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fourtk.gamepesquisa.dto.RecordDTO;
import com.fourtk.gamepesquisa.dto.RecordInsertDTO;
import com.fourtk.gamepesquisa.entities.Game;
import com.fourtk.gamepesquisa.entities.Record;
import com.fourtk.gamepesquisa.repositories.GameRepository;
import com.fourtk.gamepesquisa.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert (RecordInsertDTO dto) {
		
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		
		entity = repository.save(entity);
		
		return new RecordDTO(entity);
		
	}

}
