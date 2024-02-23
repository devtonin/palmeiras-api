package com.devtonin.palmeirasapi.infra.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.utils.PlayerConstants;

@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired  
    private TestEntityManager testEntityManager;
 
    
    @Test
    void shouldCreateNewPlayerWithValidDataSuccessfully () {
        Player player = playerRepository.save(PlayerConstants.createValidPlayer());

        Player stub = testEntityManager.find(Player.class, player.getPlayerId());

        Assertions.assertThat(stub).isNotNull();
        Assertions.assertThat(stub.getName()).isEqualTo(player.getName());
    }

    @Test
    void shouldNotCreateNewPlayerAndThrowExceptionWhenInvalidData() {
          Assertions.assertThatThrownBy( () -> playerRepository.save(null));
    }
}
