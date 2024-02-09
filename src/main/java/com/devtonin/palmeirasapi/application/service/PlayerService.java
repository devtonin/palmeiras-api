package com.devtonin.palmeirasapi.application.service;

import com.devtonin.palmeirasapi.domain.exception.BusinessException;
import com.devtonin.palmeirasapi.domain.exception.util.MessageException;
import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.infra.repository.PlayerRepository;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	private PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
    }

	public void getAllPlayers () {

	}

	public Player getPlayerById(Long playerId) {
		return playerRepository.findById(playerId).orElseThrow(() -> new BusinessException(
			MessageException.builder()
				.code("SEP-001")
				.detail("Palmeiras player not found")
				.requestDateTime(ZonedDateTime.now())
				.build()));
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
