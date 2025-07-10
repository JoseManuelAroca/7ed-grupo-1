package com.atm.buenas_practicas_java.repositories;

import com.atm.buenas_practicas_java.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByEmailOrNick (String email, String nick);
}
