package com.example.intuitplayer.services;

import com.example.intuitplayer.beans.Player;
import com.example.intuitplayer.converters.PlayerConverter;
import com.example.intuitplayer.data.domain.PlayerEntity;
import com.example.intuitplayer.data.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.intuitplayer.converters.PlayerConverter.toBean;

@Service
@AllArgsConstructor
public class GetPlayerById {

    private final PlayerRepository playerRepository;

    public Player get(String playerID) {
        return playerRepository.findById(playerID).map(PlayerConverter::toBean).orElse(null);
    }

}
