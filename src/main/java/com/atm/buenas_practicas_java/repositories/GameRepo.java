package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Integer> {
}
