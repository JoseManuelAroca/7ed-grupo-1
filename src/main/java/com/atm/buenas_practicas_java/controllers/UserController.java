package com.atm.buenas_practicas_java.controllers;

import com.atm.buenas_practicas_java.dtos.UserRegisterDTO;
import com.atm.buenas_practicas_java.entities.User;
import com.atm.buenas_practicas_java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Este mét0do prepara un objeto vacío para el formulario
    @ModelAttribute("datosUsuario")
    public UserRegisterDTO retornarNuevoUsuario() {
        return new UserRegisterDTO(); // Asegúrate de que este DTO exista
    }

    // Mostrar formulario de registro
    @GetMapping("/user/registro")
    public String registro(Model model) {
        // No hace falta añadir manualmente el DTO porque ya lo añade @ModelAttribute arriba
        return "users/registro"; // Nombre del archivo HTML
    }

    // Procesar el envío del formulario de registro
    @PostMapping("/user/registro")
    public String registroPost(@ModelAttribute("datosUsuario") UserRegisterDTO userRegisterDTO, Model model) {
        System.out.println("en el post de guardar usuario");
        System.out.println(userRegisterDTO.getEmail());
        try {
            userService.save(userRegisterDTO); // Asegúrate de tener el servicio y mét0do adecuados
            return "redirect:/user/login?exito"; // Redirige a la misma vista con parámetro en URL
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/user/registro?error";
        }
    }

    // Mostrar formulario de login
    @GetMapping("/user/login")
    public String login_user(Model model) {
        return "users/login_user"; // Nombre del archivo HTML
    }

    @GetMapping("/users/recuperar_contrasena")
    public String recuperar_cont(Model model) {return "users/recuperar_contrasena";}


    @GetMapping("/user/perfil_usuario") // ESTA ES LA URL http://localhost:8080/user/perfil_usuario
    public String perfil_usuario(Model model)
    {
        return "users/perfil_usuario"; // Nombre del archivo HTML
    }


}

