package com.fantacalcio.service;

import com.fantacalcio.model.MatchResult;
import com.fantacalcio.model.Player;
import com.fantacalcio.model.Squad;
import com.fantacalcio.model.Team;
import com.fantacalcio.repository.MatchResultRepository;
import com.fantacalcio.repository.PlayerRepository;
import com.fantacalcio.repository.SquadRepository;
import com.fantacalcio.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GameService {

    @Autowired
    private MatchResultRepository matchResultRepository;

    @Autowired
    private SquadRepository squadRepository;

    public int calculateScore(Team team, int gameweek, Map<Long, Double> playerVotes) {
        Squad squad = team.getSquad();
        double totalScore = 0;

        if (squad != null) {
            for (Player player : squad.getPlayers()) {
                totalScore += getPlayerScore(player, playerVotes);
            }
        }

        // Logica per riserva d'ufficio
        // ...

        int fantacalcioGoals = convertToFantacalcioGoals(totalScore);

        MatchResult matchResult = new MatchResult();
        matchResult.setTeam(team);
        matchResult.setGameweek(gameweek);
        matchResult.setScore(fantacalcioGoals);
        matchResultRepository.save(matchResult);

        return fantacalcioGoals;
    }

    private double getPlayerScore(Player player, Map<Long, Double> playerVotes) {
        // Logica per bonus/malus
        double baseVote = playerVotes.getOrDefault(player.getId(), 4.0); // 4 se non ha giocato

        // Esempio bonus/malus
        // baseVote += ...

        return baseVote;
    }

    private int convertToFantacalcioGoals(double totalScore) {
        if (totalScore < 66) return 0;
        if (totalScore < 72) return 1;
        if (totalScore < 78) return 2;
        if (totalScore < 84) return 3;
        if (totalScore < 90) return 4;
        return 5;
    }
}
