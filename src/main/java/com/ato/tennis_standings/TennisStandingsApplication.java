package com.ato.tennis_standings;

import com.ato.tennis_standings.model.Player;
import com.ato.tennis_standings.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TennisStandingsApplication {

  public static void main(String[] args) {
    SpringApplication.run(TennisStandingsApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(PlayerRepository repository) {
    return (args) -> {
      repository.save(new Player("Player 1", 100, 10, 7, 3));
      repository.save(new Player("Player 2", 90, 10, 6, 4));
      repository.save(new Player("Player 3", 80, 10, 5, 5));
    };
  }
}
