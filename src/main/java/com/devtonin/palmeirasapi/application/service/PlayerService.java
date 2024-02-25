package com.devtonin.palmeirasapi.application.service;

import java.util.List;
import com.devtonin.palmeirasapi.domain.model.Player;
import lombok.NonNull;

public interface PlayerService {
    public Player createPlayer(@NonNull Player player);
	public List<Player> getAllPlayers();
	public Player getPlayerById(@NonNull Long playerId);
}
