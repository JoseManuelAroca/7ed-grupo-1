package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Console;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepo extends JpaRepository<Console, Integer> {
}
