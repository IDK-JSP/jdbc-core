package com.bart.visioback.controller;

import com.bart.visioback.daos.UserDao;
import com.bart.visioback.entitys.User;
import com.bart.visioback.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserDao userDao, PasswordEncoder encoder, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            User userFound = userDao.findByEmail(user.getEmail());
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        } catch (UsernameNotFoundException e) {
            // Si l'utilisateur n'existe pas déjà, on procède à l'enregistrement
            System.out.println("test");

            User newUser = getUser(user);
            boolean isUserSaved = userDao.save(newUser);
            return isUserSaved ? ResponseEntity.ok("User registered successfully!") : ResponseEntity.badRequest().body("Error: User registration failed!");
        }
    }

    private User getUser(User user) {
        return new User(
                user.getEmail(),
                encoder.encode(user.getPassword()),
                "USER"
        );
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }

}
