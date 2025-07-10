package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Match;
import com.atm.buenas_practicas_java.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Integer> {
}
