package com.bart.visioback.controller;

import com.bart.visioback.daos.UserDao;
import com.bart.visioback.entitys.Movie;
import com.bart.visioback.entitys.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userDao.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /*@GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userDao.findAll());
    }*/

}
