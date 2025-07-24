package com.fantacalcio.controller;

import com.fantacalcio.model.Team;
import com.fantacalcio.service.LeagueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping("/{leagueId}/standings")
    public List<Team> getStandings(@PathVariable Long leagueId) {
        return leagueService.getStandings(leagueId);
    }
}
