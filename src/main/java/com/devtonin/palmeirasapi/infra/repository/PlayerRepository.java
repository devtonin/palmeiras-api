package com.devtonin.palmeirasapi.infra.repository;

import com.devtonin.palmeirasapi.domain.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
