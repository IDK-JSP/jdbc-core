package com.bart.visioback.entitys;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {
    private int id;
    @NotNull(message = "Un user id est requis")
    @NotBlank(message = "Un user id est un entier")

    private String email;
    @NotNull(message = "Un email est requis")
    @NotBlank(message = "L'email n'est pas valide")


    private String password;
    @NotNull(message = "Un mot de passe est requis")
    @NotBlank(message = "Le mot de passe n'est pas valide")

    private String role;

    public User(){}
    public User(int id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
