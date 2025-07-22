package com.fantacalcio.repository;

import com.fantacalcio.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {
    List<Squad> findByTeamId(Long teamId);
}
