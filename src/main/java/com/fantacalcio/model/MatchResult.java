package com.fantacalcio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "match_results")
@Data
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int gameweek;
    private int score;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
