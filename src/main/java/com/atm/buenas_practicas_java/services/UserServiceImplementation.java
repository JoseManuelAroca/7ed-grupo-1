package com.atm.buenas_practicas_java.services;

import com.atm.buenas_practicas_java.dtos.UserRegisterDTO;
import com.atm.buenas_practicas_java.entities.Rol;
import com.atm.buenas_practicas_java.entities.User;
import com.atm.buenas_practicas_java.repositories.RolRepo;
import com.atm.buenas_practicas_java.repositories.UserRepo;
import com.atm.buenas_practicas_java.security.PasswordConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;
    private final RolRepo rolRepo;
    private final PasswordConfiguration passwordConfiguration;


    public UserServiceImplementation(UserRepo userRepo, RolRepo rolRepo, PasswordConfiguration passwordConfiguration) {
        this.userRepo = userRepo;
        this.rolRepo = rolRepo;
        this.passwordConfiguration = passwordConfiguration;
    }

    // Guardar usuario nuevo a partir del DTO de registro
    @Override
    public User save(UserRegisterDTO userRegisterDTO) throws Exception {
        System.out.println("save en servicio user");
        if(!userRegisterDTO.getEmail().equals(userRegisterDTO.getConfirmEmail())) {
            throw new Exception("Los emails son diferentes");
        }

        if(!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            throw new Exception("Las contraseñas no coinciden");
        }

        System.out.println("save en servicio user 1");
        Optional<Rol> rol= rolRepo.findById(1L);
        User user = new User(
                userRegisterDTO.getName(),
                userRegisterDTO.getSurname(),
                userRegisterDTO.getEmail(),
                userRegisterDTO.getNick(),

                passwordConfiguration.passwordEncoder().encode(userRegisterDTO.getPassword()),
                Set.of(rol.get()) // Rol por defecto
        );
        System.out.println("save en servicio user 3");
        User user1 = userRepo.save(user);
        System.out.println("email guardado:" + user1.getEmail());
        return user1;
    }

    // Cargar usuario por su username (email o nick)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmailOrNick(username, username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getNick(),  // o user.getNick() según el login que uses
                user.getPassword(),
                mapearAutoridadesRoles(user.getRoles()) // <- faltaba esto
        );
    }


    // Convierte los roles de tu entidad a autoridades de Spring Security
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Set<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }
}

