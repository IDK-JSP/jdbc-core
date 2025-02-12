package com.bart.visioback.controller;

import com.bart.visioback.daos.MovieDao;
import com.bart.visioback.entitys.Movie;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
        Movie createdMovie = movieDao.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok(movieDao.findAll());
    }

}