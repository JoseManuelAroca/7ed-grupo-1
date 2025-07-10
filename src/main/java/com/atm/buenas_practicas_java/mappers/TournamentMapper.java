package com.atm.buenas_practicas_java.mappers;

import com.atm.buenas_practicas_java.dtos.TournamentFormDto;
import com.atm.buenas_practicas_java.dtos.TournamentRegistrationCardDto;
import com.atm.buenas_practicas_java.dtos.TournamentTableDto;
import com.atm.buenas_practicas_java.entities.Game;
import com.atm.buenas_practicas_java.entities.Tournament;
import com.atm.buenas_practicas_java.enums.Status;
import com.atm.buenas_practicas_java.repositories.GameRepo;
import com.atm.buenas_practicas_java.repositories.TournamentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TournamentMapper {

    private final GameRepo gameRepo;
    private final TournamentRepo tournamentRepo;

    /*
    Este metodo convierte los datos insertados por el administrador a la hora de añadir un torneo del DTO a su entidad correspondiente (detecta si hay que modificar o insertar por su id)
     */
    public Tournament tournamentFormDtoToEntity(TournamentFormDto dto) {
        Tournament tournament;

        if (dto.getId() != null) {
            // Carga la entidad que ya existe, para actualizarla
            tournament = tournamentRepo.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Torneo no encontrado con ID: " + dto.getId()));
        } else {
            // Crea una entidad nueva para insertar
            tournament = new Tournament();

        }

        // Actualiza los campos comunes
        tournament.setInitialDate(dto.getInitialDate());
        tournament.setWaitingTime(dto.getWaitingTime());
        tournament.setMaxTeams(dto.getMaxTeams());
        tournament.setSameNumberUsersPerTeam(dto.getSameNumberUsersPerTeam());
        tournament.setMaxUsersPerTeam(dto.getMaxUsersPerTeam());

        Game game = gameRepo.findById(dto.getGameId())
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
        tournament.setGame(game);

        return tournament;
    }

    /*
    Este metodo recibe los datos de la consulta que selecciona el torneo a modificar por su id y lo convierte a DTO para mostrar en formulario
     */
    public TournamentFormDto tournamentEntityToFormDto(Tournament tournament) {
        TournamentFormDto dto = new TournamentFormDto();
        dto.setId(tournament.getId());
        dto.setInitialDate(tournament.getInitialDate());
        dto.setWaitingTime(tournament.getWaitingTime());
        dto.setMaxTeams(tournament.getMaxTeams());
        dto.setSameNumberUsersPerTeam(tournament.getSameNumberUsersPerTeam());
        dto.setMaxUsersPerTeam(tournament.getMaxUsersPerTeam());
        dto.setGameId(tournament.getGame().getId());

        return dto;
    }

    /*
    Este metodo recibe los datos de la consulta que selecciona todos los torneos que hay y los convierte cada uno a su DTO para mostrar en tabla
     */
    public List<TournamentTableDto> TournamentTableEntityToDto(List<Tournament> tournaments) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return tournaments.stream().map(t -> {
            TournamentTableDto dto = new TournamentTableDto();
            dto.setId(t.getId());
            dto.setGameName(t.getGame().getName());

            // Modalidad: si sameNumberUsers es true, poner "maxUsersPerTeam VS maxUsersPerTeam"
            if (Boolean.TRUE.equals(t.getSameNumberUsersPerTeam())) {
                dto.setModality(t.getMaxUsersPerTeam() + " VS " + t.getMaxUsersPerTeam());
            } else {
                dto.setModality("Sin definir"); // Se debe controlar cuando el admin elige que el numero de usuarios por equipo sea diferente (2vs3, 5vs2, etc)
            }

            dto.setInitialDate(t.getInitialDate().format(dateFormatter));
            dto.setInitialHour(t.getInitialDate().format(timeFormatter));

            // Pasar el enum a String
            dto.setStatus(t.getStatus());

            return dto;

        }).toList();

    }

    /*
    Este metodo recibe los datos de todos los torneos que hay y los convierte cada uno a su DTO para mostrar en cards de torneos para inscribirse
     */
    public TournamentRegistrationCardDto toRegistrationCardDto(Tournament t) {
        TournamentRegistrationCardDto dto = new TournamentRegistrationCardDto();
        LocalDateTime cierre = t.getInitialDate().minusMinutes(t.getWaitingTime());

        dto.setId(t.getId());
        dto.setGameName(t.getGame().getName());
        dto.setModality(t.getMaxUsersPerTeam() + "vs" + t.getMaxUsersPerTeam());
        dto.setMaxTeams(t.getMaxTeams());
        dto.setInitialDate(t.getInitialDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        dto.setInitialHour(t.getInitialDate().format(DateTimeFormatter.ofPattern("HH:mm")));
        dto.setCloseDate(cierre.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        dto.setCloseHour(cierre.format(DateTimeFormatter.ofPattern("HH:mm")));

        return dto;
    }
}
