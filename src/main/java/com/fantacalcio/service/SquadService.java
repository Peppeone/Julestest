package com.fantacalcio.service;

import com.fantacalcio.model.Squad;
import com.fantacalcio.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadService {

    @Autowired
    private SquadRepository squadRepository;

    public List<Squad> getSquadByTeamId(Long teamId) {
        return squadRepository.findByTeamId(teamId);
    }

    public Squad saveSquad(Squad squad) {
        return squadRepository.save(squad);
    }
}
