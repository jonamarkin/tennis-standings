package com.ato.tennis_standings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "points")
    private int points;

    @Column(name = "games_played")
    private int gamesPlayed;

    @Column(name = "games_won")
    private int gamesWon;

    @Column(name = "games_lost")
    private int gamesLost;

    //Constructor without id
    public Player(String name, int points, int gamesPlayed, int gamesWon, int gamesLost) {
        this.name = name;
        this.points = points;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }
}
