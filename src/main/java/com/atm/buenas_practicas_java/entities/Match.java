package com.atm.buenas_practicas_java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
// Tabla de las rondas
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @Column(name = "time")
    private OffsetTime time;

    @Column(length = 75)
    private String image;

    @ManyToOne
    @JoinColumn(name = "teams_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "tournaments_id")
    private Tournament tournament;

    @OneToMany(mappedBy = "match")
    private Set<Result> results = new LinkedHashSet<>();
}
