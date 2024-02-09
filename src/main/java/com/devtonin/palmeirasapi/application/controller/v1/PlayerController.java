package com.devtonin.palmeirasapi.application.controller.v1;

import com.devtonin.palmeirasapi.application.service.PlayerService;
import com.devtonin.palmeirasapi.domain.dto.PlayerDto;
import com.devtonin.palmeirasapi.domain.mapper.PlayerMapper;
import com.devtonin.palmeirasapi.domain.model.Player;
import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/players")
@RequiredArgsConstructor
public class PlayerController {

	@NonNull
	private PlayerMapper mapper;
	
	private PlayerService playerService;

	@PostMapping
	public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
		Player player = mapper.destinationToSource(playerDto);
		Player createdPlayer = playerService.createPlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.sourceToDestination(createdPlayer));
	}
}
