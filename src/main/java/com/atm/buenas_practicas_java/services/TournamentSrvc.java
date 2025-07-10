package com.atm.buenas_practicas_java.services;

import com.atm.buenas_practicas_java.dtos.TournamentFormDto;
import com.atm.buenas_practicas_java.dtos.TournamentRegistrationCardDto;
import com.atm.buenas_practicas_java.dtos.TournamentTableDto;
import com.atm.buenas_practicas_java.entities.Console;
import com.atm.buenas_practicas_java.entities.Game;
import com.atm.buenas_practicas_java.entities.Tournament;
import com.atm.buenas_practicas_java.enums.Status;
import com.atm.buenas_practicas_java.mappers.TournamentMapper;
import com.atm.buenas_practicas_java.repositories.ConsoleRepo;
import com.atm.buenas_practicas_java.repositories.GameRepo;
import com.atm.buenas_practicas_java.repositories.TournamentRepo;
import com.atm.buenas_practicas_java.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentSrvc {

    private final TournamentRepo tournamentRepo;
    private final GameRepo gameRepo;
    private final TournamentMapper tournamentMapper;
    private final ConsoleRepo consoleRepo;

    // Listar todos los torneos activos que hay para mostrar tabla admin
    @Transactional
    public List<TournamentTableDto> getAllTournamentsTable(){
        List<Tournament> tournaments = tournamentRepo.findByActiveTrue();
        return tournamentMapper.TournamentTableEntityToDto(tournaments);
    }
    // Listar todos los torneos activos que hay para mostrar tabla admin, filtrados por consola
    @Transactional
    public List<TournamentTableDto> getTournamentsByConsole(Integer consoleId) {
        return tournamentMapper.TournamentTableEntityToDto(tournamentRepo.findByConsoleId(consoleId));
    }
    // Listar todos los torneos activos que hay para mostrar tabla admin, filtrados por estado
    @Transactional
    public List<TournamentTableDto> getTournamentsByStatus(Status status) {
        return tournamentMapper.TournamentTableEntityToDto(tournamentRepo.findByStatus(status));
    }
    // Listar todos los torneos activos que hay para mostrar tabla admin, filtrados por consola y estado
    @Transactional
    public List<TournamentTableDto> getTournamentsByConsoleAndStatus(Integer consoleId, Status status) {
        return tournamentMapper.TournamentTableEntityToDto(tournamentRepo.findByConsoleIdAndStatus(consoleId, status));
    }

    // Guarda el torneo añadido en el formulario por el admin
    public void saveTournament(TournamentFormDto tournamentFormDto){
        Tournament tournament = tournamentMapper.tournamentFormDtoToEntity(tournamentFormDto);
        tournamentRepo.save(tournament);
    }

    // Obtiene el id del torneo que se quiere modificar
    public TournamentFormDto getTournamentFormById(Integer id) {
        Tournament tournament = tournamentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado con id: " + id));
        return tournamentMapper.tournamentEntityToFormDto(tournament);
    }

    // El borrado lógico consiste en obtener el id del torneo que se quiere eliminar y establecerlo como inactivo (para no borrar datos de usuarios inscritos)
    public void logicDeleteTournament (Integer id){
        Tournament tournament = tournamentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado con id: " + id));
        tournament.setActive(false);
        tournamentRepo.save(tournament);
    }


    // Muestra todos los torneos activos cuyo status es WAITING en las cards de torneos disponibles para inscribirse
    @Transactional
    public List<TournamentRegistrationCardDto> getWaitingTournamentsCardsByConsole(String consoleName) {
        return tournamentRepo.findByStatus(Status.WAITING)
                .stream()
                .filter(t -> t.getGame().getConsoles().stream()
                        .anyMatch(c -> c.getName().equalsIgnoreCase(consoleName)))
                .map(tournamentMapper::toRegistrationCardDto)
                .toList();
    }

    // Muestra un listado de todos los juegos para el desplegable
    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }

    // Muestra todas las consolas disponibles para aplicar el filtrado
    public List<Console> getAllConsoles(){
        return consoleRepo.findAll();
    }


}
