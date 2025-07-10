package com.atm.buenas_practicas_java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 75, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "consoles_games",
            joinColumns = @JoinColumn(name = "games_id"),       // Aquí va la columna de esta tabla (games)
            inverseJoinColumns = @JoinColumn(name = "consoles_id") // Y aquí la columna de la tabla contraria (consoles)
    )

    private Set<Console> consoles = new LinkedHashSet<>();
}