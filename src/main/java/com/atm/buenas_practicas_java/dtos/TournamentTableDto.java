package com.atm.buenas_practicas_java.dtos;

import com.atm.buenas_practicas_java.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentTableDto {
    private Integer id;
    private String gameName;
    private String modality;
    private String initialDate;
    private String initialHour;
    private Status status;
}