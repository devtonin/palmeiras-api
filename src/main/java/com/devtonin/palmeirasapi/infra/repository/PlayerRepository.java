package com.devtonin.palmeirasapi.infra.repository;

import com.devtonin.palmeirasapi.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
