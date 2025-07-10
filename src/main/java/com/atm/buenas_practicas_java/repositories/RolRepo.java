package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.Rol;
import com.atm.buenas_practicas_java.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Rol,Long> {

}
