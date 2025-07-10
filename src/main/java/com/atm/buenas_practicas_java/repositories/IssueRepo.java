package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue,Integer> {
}
