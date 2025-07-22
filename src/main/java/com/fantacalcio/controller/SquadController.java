package com.fantacalcio.controller;

import com.fantacalcio.model.Squad;
import com.fantacalcio.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/squads")
public class SquadController {

    @Autowired
    private SquadService squadService;

    @GetMapping("/{teamId}")
    public List<Squad> getSquadByTeamId(@PathVariable Long teamId) {
        return squadService.getSquadByTeamId(teamId);
    }

    @PostMapping("/{teamId}")
    public Squad setSquad(@PathVariable Long teamId, @RequestBody Squad squad) {
        return squadService.saveSquad(squad);
    }
}
