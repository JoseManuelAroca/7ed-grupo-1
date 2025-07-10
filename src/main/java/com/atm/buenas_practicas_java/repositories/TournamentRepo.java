package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Tournament;
import com.atm.buenas_practicas_java.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepo extends JpaRepository<Tournament,Integer> {
    List<Tournament> findByActiveTrue(); // Spring Data JPA crea automáticamente la consulta (donde active sea true)

    // FILTROS ----------------
    // Por consola
    @Query("SELECT t FROM Tournament t WHERE t.active = true AND :consoleId IN (SELECT c.id FROM t.game.consoles c)")
    List<Tournament> findByConsoleId(@Param("consoleId") Integer consoleId);

    // Por estado
    @Query("SELECT t FROM Tournament t WHERE t.active = true AND t.status = :status")
    List<Tournament> findByStatus(@Param("status") Status status);

    // Por consola y estado
    @Query("SELECT t FROM Tournament t WHERE t.active = true AND t.status = :status AND :consoleId IN (SELECT c.id FROM t.game.consoles c)")
    List<Tournament> findByConsoleIdAndStatus(@Param("consoleId") Integer consoleId, @Param("status") Status status);
}
