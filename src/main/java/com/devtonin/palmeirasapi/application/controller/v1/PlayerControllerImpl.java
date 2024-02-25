package com.devtonin.palmeirasapi.application.controller.v1;

import com.devtonin.palmeirasapi.application.service.PlayerService;
import com.devtonin.palmeirasapi.domain.dto.PlayerDto;
import com.devtonin.palmeirasapi.domain.mapper.PlayerMapper;
import com.devtonin.palmeirasapi.domain.model.Player;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerControllerImpl implements PlayerController {

	@NonNull
	private PlayerMapper playerMapper;

	@Autowired
	private PlayerService playerService;

	@Override
	public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
		Player player = playerMapper.destinationToSource(playerDto);
		Player createdPlayer = playerService.createPlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).body(playerMapper.sourceToDestination(createdPlayer));
	}

	@Override
	public ResponseEntity<List<PlayerDto>> getAllPlayers() {
		List<Player> playersFound = playerService.getAllPlayers();
		return ResponseEntity.status(HttpStatus.OK).body(playerMapper.sourceToDestination(playersFound));
	}
	
	@Override
	public ResponseEntity<PlayerDto> getPlayerById (@PathVariable Long playerId) {
		Player playerFound = playerService.getPlayerById(playerId);
		return ResponseEntity.status(HttpStatus.OK).body(playerMapper.sourceToDestination(playerFound));
	}
}
