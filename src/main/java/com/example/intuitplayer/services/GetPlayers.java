package com.example.intuitplayer.services;

import com.example.intuitplayer.beans.Player;
import com.example.intuitplayer.converters.PlayerConverter;
import com.example.intuitplayer.data.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class GetPlayers {

    private final PlayerRepository playerRepository;

    public List<Player> get() {
        return playerRepository.findAll().stream().map(PlayerConverter::toBean).collect(toList());
    }

}
