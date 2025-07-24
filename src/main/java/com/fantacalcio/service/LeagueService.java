package com.fantacalcio.service;

import com.fantacalcio.model.League;
import com.fantacalcio.model.Team;
import com.fantacalcio.repository.LeagueRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<Team> getStandings(Long leagueId) {
        League league = leagueRepository.findById(leagueId).orElse(null);
        if (league == null) {
            return null;
        }
        return league.getTeams().stream()
                .sorted(Comparator.comparing(Team::getPoints).reversed())
                .collect(Collectors.toList());
    }
}
