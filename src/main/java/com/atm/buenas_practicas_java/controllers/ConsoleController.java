package com.atm.buenas_practicas_java.controllers;

//SPRING FRAMEWORK-----------------------------------
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsoleController {


    public ConsoleController() {

    }

    /**
     *
     * Esta es la vista que usaremos para mostrar los cambios de la plantilla base.
     *
     * @param model El objeto del modelo que se utiliza para compartir datos entre el backend y la vista.
     * @return La vista base
     */

    @GetMapping("consolas/nintendoswitch")
    public String nintendoswitch(Model model) {
        return "consolas/nintendoswitch";
    }

    @GetMapping("consolas/pc")
    public String pc(Model model)
    {
        return "consolas/pc";
    }

    @GetMapping("consolas/playstation")
    public String playstation(Model model)
    {
        return "consolas/playstation";
    }

    @GetMapping("consolas/xbox")
    public String xbox(Model model)
    {
        return "consolas/xbox";
    }

}





