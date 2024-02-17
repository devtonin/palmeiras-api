package com.devtonin.palmeirasapi.infra.repository;

import com.devtonin.palmeirasapi.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    //TODO: criar interfaces e renomear esses pra impl -> service, controller e repository (Inversão de dependência)
}
