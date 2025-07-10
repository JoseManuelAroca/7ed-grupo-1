package com.atm.buenas_practicas_java.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentRegistrationCardDto {
    private Integer id;
    private String gameName;
    private String modality;
    private Short maxTeams;
    // Falta el de los jugadores inscritos que aun no puedo
    private String initialDate;
    private String initialHour;
    private String closeDate;
    private String closeHour;
}
