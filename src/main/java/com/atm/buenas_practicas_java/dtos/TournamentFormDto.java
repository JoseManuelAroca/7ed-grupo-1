package com.atm.buenas_practicas_java.dtos;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TournamentFormDto {

    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime initialDate;

    // El estado del torneo se pone a WAITING por defecto al crearse (propiedad status)
    // La fecha de creación se pone a TODAY por defecto al crearse (propiedad creationDate)

    // El administrador puede elegir las siguientes propiedades del torneo:
    private Short waitingTime;
    private Short maxTeams;
    private Boolean sameNumberUsersPerTeam;
    private Short maxUsersPerTeam;
    private Integer gameId; // ID del juego seleccionado
}
