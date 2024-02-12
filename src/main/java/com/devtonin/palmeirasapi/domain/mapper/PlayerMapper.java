package com.devtonin.palmeirasapi.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.devtonin.palmeirasapi.domain.dto.PlayerDto;
import com.devtonin.palmeirasapi.domain.model.Player;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerMapper {

    Player destinationToSource(PlayerDto source);

    PlayerDto sourceToDestination(Player source);

    List<PlayerDto> sourceToDestination(List<Player> source);
    
}
