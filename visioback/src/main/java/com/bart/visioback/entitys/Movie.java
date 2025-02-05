package com.bart.visioback.entitys;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Movie {

    private int movie_id;
    @NotNull(message = "Un movie id est requis")
    @NotBlank(message = "Un movie id est un entier")

    private String title;
    @NotBlank(message = "Le movie doit avoir un titre")
    @NotNull(message = "Le movie doit avec un titre non nul")

    private String poster_path;

    public Movie(int movie_id, String poster_path, String title) {
        this.movie_id = movie_id;
        this.title = title;
        this.poster_path = poster_path;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
