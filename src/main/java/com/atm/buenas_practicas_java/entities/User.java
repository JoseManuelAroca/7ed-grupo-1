package com.atm.buenas_practicas_java.entities;

import com.atm.buenas_practicas_java.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false)
    private String surname;

    @Column(length = 120, nullable = false)
    private String email;

    @Column(length = 75, nullable = false)
    private String nick;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 200)
    private String biography;

    @Column(length = 75)
    private String country;

    // esta columna de la BBDD representa el tipo de perfil que posee el usuario: privado o público
    @Column(name = "profile_settings", nullable = false)
    private boolean profileSettings = false;

    @Column(name = "user_points", nullable = false)
    private Long userPoints = 0L;


//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, length = 75)
//    private Roles role; //Guarda el valor como string en la base de datos, posibles valores: ADMIN, USER (Un usuario solo puede tener un tipo)

    // esta columna de la BBDD representa el rol que tendrá un usuario durante una partida: ej: verificador
    @Column(name = "verifier", nullable = false)
    private boolean verifier = false;


    /* Si se quiere que un usuario tenga mas de un tipo (Un usuario puede ser administrador y usuario a la vez) entonces:
    @ElementCollection(targetClass = UsersTypes.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_types", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "type", nullable = false)
    private List<UsersTypes> type;
     */

    private String image;

    @Basic(optional = false)
    private boolean active = true;

    // Relaciones
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Issue> issues = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "teams_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "teams_id")
    )

    private Set<Team> teams = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )

    private Set<Rol> roles;

    public User(String name, String surname, String email, String nick, String password, Set<Rol> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

}

