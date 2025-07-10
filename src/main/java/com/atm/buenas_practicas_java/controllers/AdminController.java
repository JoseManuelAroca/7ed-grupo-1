package com.atm.buenas_practicas_java.controllers;

import com.atm.buenas_practicas_java.dtos.TournamentFormDto;
import com.atm.buenas_practicas_java.dtos.TournamentTableDto;
import com.atm.buenas_practicas_java.entities.Tournament;
import com.atm.buenas_practicas_java.enums.Status;
import com.atm.buenas_practicas_java.services.TournamentSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final TournamentSrvc tournamentSrvc;

    public AdminController(TournamentSrvc tournamentSrvc) {
        this.tournamentSrvc = tournamentSrvc;
    }

    /**
     *
     * Esta es la vista que usaremos para mostrar los cambios de la plantilla base.
     *
     * @param model El objeto del modelo que se utiliza para compartir datos entre el backend y la vista.
     * @return La vista base
     */
    //@GetMapping("/{admin}")
    @GetMapping("/user_admin")
    public String mostrarPantallaAdmin(@RequestParam(name = "consoleId", required = false) Integer consoleId,
                                       @RequestParam(name = "status", required = false) Status status,
                                       @RequestParam(name = "editId", required = false) Integer editId,
                                       Model model)
    {
        List<TournamentTableDto> torneos;

        if (consoleId != null && status != null) {
            torneos = tournamentSrvc.getTournamentsByConsoleAndStatus(consoleId, status);
        } else if (consoleId != null) {
            torneos = tournamentSrvc.getTournamentsByConsole(consoleId);
        } else if (status != null) {
            torneos = tournamentSrvc.getTournamentsByStatus(status);
        } else {
            torneos = tournamentSrvc.getAllTournamentsTable();
        }

        // --- Formulario: nuevo o edición ---
        TournamentFormDto torneoForm = (editId != null)
                ? tournamentSrvc.getTournamentFormById(editId)
                : new TournamentFormDto();

        model.addAttribute("tournament", torneoForm);
        model.addAttribute("games", tournamentSrvc.getAllGames());
        model.addAttribute("torneos", torneos);
        model.addAttribute("statuses", Status.values());
        model.addAttribute("consoles", tournamentSrvc.getAllConsoles());

        return "admin/user_admin";// Nombre del archivo HTML
    }

    @PostMapping("/torneos/guardar")
    public String guardarTorneo(@ModelAttribute TournamentFormDto tournamentFormDto) {
        // 1 - Verificar los datos obtenidos??

        // 2- Guardar en la BBDD
        tournamentSrvc.saveTournament(tournamentFormDto);
        return "redirect:/admin/user_admin";
    }

//    @GetMapping("/torneos/editar/{id}")
//    public String editarTorneo(@PathVariable Integer id, Model model) {
//        TournamentFormDto torneo = tournamentSrvc.getTournamentFormById(id);
//
//        model.addAttribute("tournament", torneo); // Esto rellena el formulario
//        model.addAttribute("games", tournamentSrvc.getAllGames());
//        model.addAttribute("torneos", tournamentSrvc.getAllTournamentsTable());
//
//        return "admin/user_admin";
//    }

    @GetMapping("/torneos/borrar/{id}")
    public String borrarLogicoTorneo(@PathVariable Integer id) {
        tournamentSrvc.logicDeleteTournament(id);
        return "redirect:/admin/user_admin";
    }

}
