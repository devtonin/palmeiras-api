package com.devtonin.palmeirasapi.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.devtonin.palmeirasapi.domain.exception.BusinessException;
import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.infra.repository.PlayerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTests {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void shouldCreateNewPlayerWithValidDataSuccessfully () {
        Player validPlayer = PlayerConstants.createValidPlayer();
        
        when(playerRepository.save(validPlayer)).thenReturn(validPlayer);
        Player createdPlayer = playerService.createPlayer(validPlayer);

        assertEquals(validPlayer, createdPlayer);
        assertNotNull(createdPlayer);
    }

    @Test
    void shouldNotCreateNewPlayerWhenInvalidData() {
        Player invalidPlayer = PlayerConstants.createInvalidPlayer();

        when(playerRepository.save(invalidPlayer))
            .thenThrow(BusinessException.class);

        Assertions.assertThatThrownBy(() -> playerService.createPlayer(invalidPlayer))
            .isInstanceOf(BusinessException.class);
    }

    @Test
    void shouldGetAllPlayersSuccessfully () {
        Player validPlayer = PlayerConstants.createValidPlayer();
        List<Player> players = new ArrayList<Player>();
        players.add(validPlayer);

        when(playerRepository.findAll()).thenReturn(players);

        List<Player> playersFound = playerService.getAllPlayers();

        
        Assertions.assertThatNoException();
        assertNotNull(playersFound);
    }

    @Test
    void shouldNotGetAllPlayersWhenDatabaseIsEmpty () {
        Player validPlayer = PlayerConstants.createValidPlayer();
        List<Player> players = new ArrayList<Player>();
        players.add(validPlayer);

        when(playerRepository.findAll()).thenReturn(new ArrayList<Player>());

        Assertions.assertThatThrownBy(() -> playerService.getAllPlayers())
            .isInstanceOf(BusinessException.class);
    }

    @Test
    void shouldGetPlayerByIdSuccessfully () {
        Player validPlayer = PlayerConstants.createValidPlayer();
    
        when(playerRepository.findById(validPlayer.getPlayerId())).thenReturn(Optional.ofNullable((Player) validPlayer));

        Player playerFound = playerService.getPlayerById(validPlayer.getPlayerId());

        Assertions.assertThatNoException();
        assertNotNull(playerFound);
        assertEquals(validPlayer, playerFound);
    }

    @Test
    void shouldNotGetPlayerByIdWhenPlayerDoesNotExists () {
        Player validPlayer = PlayerConstants.createValidPlayer();
    
        when(playerRepository.findById(validPlayer.getPlayerId())).thenReturn(null);

        Assertions.assertThatThrownBy(() -> playerService.getPlayerById(validPlayer.getPlayerId()))
        .isInstanceOf(BusinessException.class);
    }

}
