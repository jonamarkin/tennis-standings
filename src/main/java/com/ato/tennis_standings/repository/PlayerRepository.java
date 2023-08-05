package com.ato.tennis_standings.repository;

import com.ato.tennis_standings.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}
