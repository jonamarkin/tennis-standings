package com.ato.tennis_standings.controller;

import com.ato.tennis_standings.dto.PlayerResponse;
import com.ato.tennis_standings.model.Player;
import com.ato.tennis_standings.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<PlayerResponse> getAllPlayers() {
        PlayerResponse playerResponse =  playerService.getAllPlayers();
        log.info("PlayerResponse: {}", playerResponse);
        return ResponseEntity.ok(playerResponse);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(Long id) {
        PlayerResponse playerResponse =  playerService.getPlayerById(id);
        log.info("PlayerResponse: {}", playerResponse);
        return ResponseEntity.ok(playerResponse);
    }
}
