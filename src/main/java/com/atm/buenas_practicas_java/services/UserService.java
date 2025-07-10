package com.atm.buenas_practicas_java.services;

import com.atm.buenas_practicas_java.dtos.UserRegisterDTO;
import com.atm.buenas_practicas_java.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    public User save (UserRegisterDTO userRegisterDTO) throws Exception;




}
