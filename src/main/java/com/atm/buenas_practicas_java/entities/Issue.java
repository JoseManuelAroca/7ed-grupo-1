package com.atm.buenas_practicas_java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 75)
    private String name;

    @Column(length = 1000)
    private String message;

    @Column(length = 75)
    private String email;

    @Column(name = "message_type", length = 75)
    private String tipoMensaje;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}