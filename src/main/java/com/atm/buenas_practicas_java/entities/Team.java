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
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 75)
    private String name;

    @ManyToMany(mappedBy = "teams")
    private Set<User> users = new LinkedHashSet<>();

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Match> matches = new LinkedHashSet<>();
}