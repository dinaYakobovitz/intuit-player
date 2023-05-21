package com.example.intuitplayer.converters;

import com.example.intuitplayer.beans.Player;
import com.example.intuitplayer.data.domain.PlayerEntity;
import com.example.intuitplayer.models.PlayerModel;
import lombok.experimental.UtilityClass;

import static java.lang.Integer.getInteger;

@UtilityClass
public class PlayerConverter {
    public static PlayerEntity toPlayerEntity(PlayerModel player) {
        return PlayerEntity.builder()
                .playerID(player.getPlayerID())
                .birthYear(getInteger(player.getBirthYear()))
                .birthMonth(getInteger(player.getBirthMonth()))
                .birthDay(getInteger(player.getBirthDay()))
                .birthCountry(player.getBirthCountry())
                .birthState(player.getBirthState())
                .birthCity(player.getBirthCountry())
                .birthCountry(player.getBirthCountry()).build();

    }

    public static Player toBean(PlayerEntity player) {
        return Player.builder()
                .playerID(player.getPlayerID())
                .birthYear(player.getBirthYear())
                .birthMonth(player.getBirthMonth())
                .birthDay(player.getBirthDay())
                .birthCountry(player.getBirthCountry())
                .birthState(player.getBirthState())
                .birthCity(player.getBirthCountry())
                .birthCountry(player.getBirthCountry()).build();

    }
}
