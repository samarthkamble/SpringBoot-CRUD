package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/{password}")
    public ResponseEntity<Users> createUser(@RequestBody Users user, @PathVariable String password) {
        user.setPassword(password);
        Users savedUser = usersService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userName}/{password}")
    public ResponseEntity<String> validateUser(@PathVariable String userName, @PathVariable String password) {
        boolean isValidUser = usersService.validateUser(userName, password);
        if (isValidUser) {
            return new ResponseEntity<>("Valid user", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid user", HttpStatus.UNAUTHORIZED);
        }
    }
}
