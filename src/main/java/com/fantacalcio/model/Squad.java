package com.fantacalcio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "squads")
@Data
@IdClass(Squad.SquadId.class)
public class Squad {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private boolean isStarter;

    public static class SquadId implements Serializable {
        private Long team;
        private Long player;
    }
}
