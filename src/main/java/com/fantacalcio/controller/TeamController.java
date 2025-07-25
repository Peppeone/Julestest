package com.fantacalcio.controller;

import com.fantacalcio.model.Squad;
import com.fantacalcio.model.Team;
import com.fantacalcio.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @PostMapping("/{teamId}/players")
    public Squad addPlayerToSquad(@PathVariable Long teamId, @RequestBody Long playerId) {
        return teamService.addPlayerToSquad(teamId, playerId);
    }
}
