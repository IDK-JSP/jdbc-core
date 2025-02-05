package com.bart.visioback.controller;

import com.bart.visioback.daos.UserDao;
import com.bart.visioback.entitys.Movie;
import com.bart.visioback.entitys.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userDao.findById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<User>> getUserByEmail(@RequestParam String query){
        return  ResponseEntity.ok(Collections.singletonList(userDao.findByEmail(query)));
    }

}
