package com.atm.buenas_practicas_java.controllers;

import com.atm.buenas_practicas_java.dtos.TournamentRegistrationCardDto;
import com.atm.buenas_practicas_java.services.TournamentSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TorneosController {

    private final TournamentSrvc tournamentService;

    @Autowired
    public TorneosController(TournamentSrvc tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/torneos/torneosdisponiblespc")
    public String torneosDisponiblesPc(Model model) {
        List<TournamentRegistrationCardDto> torneos = tournamentService.getWaitingTournamentsCardsByConsole("PC");
        model.addAttribute("torneos", torneos);
        return "torneos/torneosdisponiblespc";
    }

    @GetMapping("/torneos/torneosdisponiblesplay")
    public String torneosDisponiblesPlay(Model model) {
        List<TournamentRegistrationCardDto> torneos = tournamentService.getWaitingTournamentsCardsByConsole("PS5");
        model.addAttribute("torneos", torneos);
        return "torneos/torneosdisponiblesplay";
    }

    @GetMapping("/torneos/torneosdisponiblesswitch")
    public String torneosDisponiblesSwitch(Model model) {
        List<TournamentRegistrationCardDto> torneos = tournamentService.getWaitingTournamentsCardsByConsole("Nintendo Switch");
        model.addAttribute("torneos", torneos);
        return "torneos/torneosdisponiblesswitch";
    }

    @GetMapping("/torneos/torneosdisponiblesxbox")
    public String torneosDisponiblesXbox(Model model) {
        List<TournamentRegistrationCardDto> torneos = tournamentService.getWaitingTournamentsCardsByConsole("Xbox");
        model.addAttribute("torneos", torneos);
        return "torneos/torneosdisponiblesxbox";
    }

    @GetMapping("/torneos/inscripciontorneo")
    public String inscripciontorneo(Model model) {
        return "torneos/inscripciontorneo";
    }

    @GetMapping("/torneos/brackets")
    public String brackets(Model model) {
        return "torneos/brackets";
    }
}






