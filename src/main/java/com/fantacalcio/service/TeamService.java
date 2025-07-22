package com.fantacalcio.service;

import com.fantacalcio.model.Team;
import com.fantacalcio.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            team.setName(teamDetails.getName());
            team.setBudget(teamDetails.getBudget());
            return teamRepository.save(team);
        }
        return null;
    }
}
