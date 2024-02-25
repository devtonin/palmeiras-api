package com.devtonin.palmeirasapi.application.controller.v1;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.devtonin.palmeirasapi.domain.dto.PlayerDto;

@RequestMapping("/palmeiras-api/v1/players")
public interface PlayerController {

    @PostMapping
	public ResponseEntity<PlayerDto> createPlayer(PlayerDto playerDto);

    @GetMapping
	public ResponseEntity<List<PlayerDto>> getAllPlayers();

    @GetMapping(path = {"/{playerId}"})
	public ResponseEntity<PlayerDto> getPlayerById (Long playerId);
    
}
