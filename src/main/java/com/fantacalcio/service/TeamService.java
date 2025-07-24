package com.fantacalcio.service;

import com.fantacalcio.model.Player;
import com.fantacalcio.model.Squad;
import com.fantacalcio.model.Team;
import com.fantacalcio.repository.PlayerRepository;
import com.fantacalcio.repository.SquadRepository;
import com.fantacalcio.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SquadRepository squadRepository;

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

    public Squad addPlayerToSquad(Long teamId, Long playerId) {
        Team team = getTeamById(teamId);
        Player player = playerRepository.findById(playerId).orElse(null);

        if (team != null && player != null) {
            Squad squad = team.getSquad();
            if (squad == null) {
                squad = new Squad();
                squad.setTeam(team);
            }
            squad.getPlayers().add(player);
            return squadRepository.save(squad);
        }
        return null;
    }
}
