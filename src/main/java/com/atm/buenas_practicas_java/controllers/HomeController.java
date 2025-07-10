package com.atm.buenas_practicas_java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
    }
    @GetMapping("/home") //ESTA ES LA URL http://localhost:8080/home
    public String home(Model model)
    {
        return "home/home"; // Nombre del archivo HTML
    }

    @GetMapping("/about_us") //ESTA ES LA URL http://localhost:8080/about_us
    public String about_us(Model model)
    {
        return "about_us/about_us"; // Nombre del archivo HTML
    }




}
