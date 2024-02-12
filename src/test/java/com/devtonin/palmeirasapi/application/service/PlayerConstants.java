package com.devtonin.palmeirasapi.application.service;

import com.devtonin.palmeirasapi.domain.model.Player;
import com.devtonin.palmeirasapi.domain.model.PositionEnum;

public class PlayerConstants {

    public static Player createValidPlayer() {
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

    public static Player createInvalidPlayer() {
        return Player.builder()
                .name(" ")
                .playerId(53413124L)
                .shirtNumber(null)
                .position(PositionEnum.PRIMEIRO_VOLANTE)
                .age(25)
                .height("")
                .weight(" ")
                .isBagre(false)
                .build();
    }

}
