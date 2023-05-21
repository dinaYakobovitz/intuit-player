package com.example.intuitplayer.controllers;

import com.example.intuitplayer.beans.Player;
import com.example.intuitplayer.services.GetPlayerById;
import com.example.intuitplayer.services.GetPlayers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/players")
public class PlayerRestController {
    private final GetPlayers getPlayers;
    private final GetPlayerById getPlayerById;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(getPlayers.get());
    }

    @GetMapping("/{playerID}")
    public ResponseEntity<Player> getPlayer(@PathVariable String playerID) {
        return ResponseEntity.status(HttpStatus.OK).body(getPlayerById.get(playerID));
    }

}
