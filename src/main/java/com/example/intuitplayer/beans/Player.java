package com.example.intuitplayer.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class Player {
    String playerID;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    String birthCountry;
    String birthState;
    String birthCity;
    Integer deathYear;
    Integer deathMonth;
    Integer deathDay;
    String deathCountry;
    String deathState;
    String deathCity;
    String nameFirst;
    String nameLast;
    String nameGiven;
    Integer weight;
    Integer height;
    String bats;
    @JsonProperty("throws")
    String throwsType;
    String debut;
    String finalGame;
    String retroID;
    String bbrefID;
}
