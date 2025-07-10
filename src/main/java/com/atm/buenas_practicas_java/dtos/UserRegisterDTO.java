package com.atm.buenas_practicas_java.dtos;

public class UserRegisterDTO {


    private Long id;
    private String name;
    private String surname;
    private String email;
    private String confirmEmail;
    private String nick;
    private String password;
    private String confirmPassword;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRegisterDTO(Long id, String name, String surname, String email, String nick, String password, String confirmEmail, String confirmPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.confirmEmail=confirmEmail;
        this.confirmPassword=confirmPassword;

    }

    public UserRegisterDTO(String email) {
        this.email = email;
    }

    public UserRegisterDTO() {
    }
}
