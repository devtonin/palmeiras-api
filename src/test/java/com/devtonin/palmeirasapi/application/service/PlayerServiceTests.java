package com.devtonin.palmeirasapi.application.service;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.domain.model.PositionEnum;
import com.devtonin.palmeirasapi.infra.repository.PlayerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTests {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;


    @Test
    void shouldCreatePlayerWithValidDataSuccessfully () {
        Player player = createValidPlayer();
        
        when(playerRepository.save(player)).thenReturn(player);
        Player createdPlayer = playerService.createPlayer(player);

        Assertions.assertEquals(player, createdPlayer);
        Assertions.assertNotNull(createdPlayer);
    }
    

    public static Player createValidPlayer () {
        return Player.builder()
            .name("Aníbal Moreno")
            .playerId(53413124L)
            .shirtNumber(5)
            .position(PositionEnum.PRIMEIRO_VOLANTE)
            .age(25)
            .height("1.74")
            .weight("75kg")
            .isBagre(false)
        .build();    
    }
}
