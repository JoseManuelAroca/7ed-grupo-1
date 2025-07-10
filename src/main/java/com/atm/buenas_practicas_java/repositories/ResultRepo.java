package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result,Integer> {
}
