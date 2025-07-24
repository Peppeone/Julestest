package com.fantacalcio.model;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double budget;
    private Integer points = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Squad squad;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
}
