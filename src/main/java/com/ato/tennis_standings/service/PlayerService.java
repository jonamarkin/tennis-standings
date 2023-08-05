package com.ato.tennis_standings.service;

import com.ato.tennis_standings.dto.PlayerResponse;
import com.ato.tennis_standings.model.Player;
import com.ato.tennis_standings.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerResponse getAllPlayers() {
        List<Player> players =  playerRepository.findAll();
        log.info("Players: {}", players);
        return new PlayerResponse("200", "Success", players);
    }

    public PlayerResponse getPlayerById(Long id) {
        Player player =  playerRepository.findById(id).orElse(null);
        log.info("Player: {}", player);
        return new PlayerResponse("200", "Success", player);
    }
}
