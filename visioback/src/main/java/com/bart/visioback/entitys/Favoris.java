package com.bart.visioback.entitys;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Favoris {
    private int user_id;
    @NotNull(message = "Un user id est requis")
    @NotBlank(message = "Un user id est un entier")
    
    private int movie_id;
    @NotNull(message = "Un movie id est requis")
    @NotBlank(message = "Un movie id est un entier")

    public Favoris( int user_id, int movie_id) {
        this.user_id = user_id;
        this.movie_id = movie_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}