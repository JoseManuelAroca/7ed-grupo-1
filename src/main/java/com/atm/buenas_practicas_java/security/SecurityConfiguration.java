package com.atm.buenas_practicas_java.security;

import com.atm.buenas_practicas_java.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserService userService;
    private final PasswordConfiguration passwordConfiguration;

    public SecurityConfiguration(UserService userService, PasswordConfiguration passwordConfiguration) {
        this.userService = userService;
        this.passwordConfiguration = passwordConfiguration;
    }


    //Para registrar otro met0do
//    UserDetailsService	Busca los datos del usuario (normalmente en la base de datos)
//    PasswordEncoder	Cifra la contraseña y la compara de forma segura
//    DaoAuthenticationProvider	Gestiona t0do el proceso de autenticación basándose en lo anterior


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordConfiguration.passwordEncoder());
        return auth;
    }

    //T0da url o ruta de archivo que se incluya, será permitida por cualquiera y en caso contrario, debe estar loggeado
    //Para el formulario de login: es la pag/login y que cualquiera puede acceder
    //Para el logout especificamos la url y que luego limpie la sesion y la autenticación y en caso de que haya ido bien,
    //redirigimos a lo que queramos (por ejemplo home)


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(auth -> auth
                        // Paginas a las que se puede acceder sin login
                        .requestMatchers("/fonts/**", "/css/**", "/javascript/**",
                                "/images/**","/videos/**","/", "/user/registro",
                                "/login/**", "/home","/about_us","/users/recuperar_contrasena",
                                "/consolas/**").permitAll()
                        // Ruta de administración
                        .requestMatchers("/torneos/borrar/**", "/torneos/guardar",
                                "/user_admin").hasRole("ADMIN")
                        // Restro de requests autenticadas por defecto
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/home", true) //en caso de que el login vaya bien te redirige a... USA UN HTTP GET
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // <- Esta línea reemplaza AntPathRequestMatcher
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/home")
                        .permitAll()
                );

        return http.build();
    }

}