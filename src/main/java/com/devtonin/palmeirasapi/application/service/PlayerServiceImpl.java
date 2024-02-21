package com.devtonin.palmeirasapi.application.service;

import com.devtonin.palmeirasapi.domain.exception.util.BusinessExceptionUtils;
import com.devtonin.palmeirasapi.domain.exception.util.MessageException;
import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.infra.repository.PlayerRepository;
import lombok.NonNull;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl {
	
	private PlayerRepository playerRepository;

	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Player createPlayer(@NonNull Player player) {
		return playerRepository.save(player);
    }

	public List<Player> getAllPlayers () {
		BusinessExceptionUtils.throwsIf(playerRepository.findAll().isEmpty(), 
			MessageException.builder()
			    .code("SEP-002")
				.detail("0 players found")
				.requestDateTime(ZonedDateTime.now())
				.build());

		return playerRepository.findAll();
	}

	public Player getPlayerById(@NonNull Long playerId) {
		BusinessExceptionUtils.throwsIf(playerRepository.findById(playerId) == null,
			MessageException.builder()
			    .code("SEP-001")
				.detail("Player not found")
				.requestDateTime(ZonedDateTime.now())
				.build());

		return playerRepository.findById(playerId).get();
	}

	public void editPlayer () {
		
	}

	public void deletePlayer() {

	}

	public void lonePlayer () {

	}

	public void sellPlayer () {

	}

	public void enterPlayerToDm() {

	}

	public void healPlayer () {


	}

	public void registerPlayerToBid () {

	}
}
