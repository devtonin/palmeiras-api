package com.devtonin.palmeirasapi.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
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
        Player player = PlayerConstants.createValidPlayer();
        
        when(playerRepository.save(player)).thenReturn(player);
        Player createdPlayer = playerService.createPlayer(player);

        assertEquals(player, createdPlayer);
        assertNotNull(createdPlayer);
    }

    @Test
    void shouldNotCreateNewPlayerWithInvalidData() {
        Player player = PlayerConstants.createInvalidPlayer();

        when(playerRepository.save(player))
            .thenThrow(BusinessException.class);

        Assertions.assertThatThrownBy(() -> playerService.createPlayer(player))
            .isInstanceOf(BusinessException.class);
    }

}
