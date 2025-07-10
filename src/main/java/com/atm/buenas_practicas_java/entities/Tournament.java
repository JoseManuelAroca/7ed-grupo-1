package com.atm.buenas_practicas_java.entities;

import com.atm.buenas_practicas_java.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "initial_date")
    private LocalDateTime initialDate;

    // Debería de ponerse una fecha fin para que cuando haya ganador poner status a FINISHED y guardar la fecha en la que ha finalizado??
//    @Column(name = "finish_date")
//    private LocalDateTime finishDate;

    @Column(name = "waiting_time")
    private Short waitingTime;

    // Para saber si el torneo está esperando (POR DEFECTO), en marcha, terminado, caducado (se cumple la fecha y no se llega a poner en marcha)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 75)
    private Status status = Status.WAITING;

    //10
    @Column(name = "max_teams", nullable = false)
    private Short maxTeams = 0;

    //yes
    @Column(name = "same_number_users_per_team")
    private Boolean sameNumberUsersPerTeam;

    //1
    @Column(name = "max_users_per_team")
    private Short maxUsersPerTeam;

    // Sirve para hacer el borrado lógico de torneos
    @Basic(optional = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
    private Set<Match> matches = new LinkedHashSet<>();
}
