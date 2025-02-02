package com.bart.visioback.controller;

import com.bart.visioback.daos.FavorisDao;
import com.bart.visioback.entitys.Favoris;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoris")
@CrossOrigin(origins = "http://localhost:3000")
public class FavorisController {
    private final FavorisDao favorisDao;

    public FavorisController(FavorisDao favorisDao) {
        this.favorisDao = favorisDao;
    }
    @PostMapping
    public ResponseEntity<Favoris> createFavoris(@RequestBody Favoris favoris) {
        Favoris createdFavoris = favorisDao.save(favoris);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFavoris);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Favoris>> getAllFavoris(){
        return ResponseEntity.ok(favorisDao.findAll());
    }

}