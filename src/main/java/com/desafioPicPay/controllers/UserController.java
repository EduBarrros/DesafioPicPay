package com.desafioPicPay.controllers;

import com.desafioPicPay.domain.user.User;
import com.desafioPicPay.dtos.UserDTO;
import com.desafioPicPay.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = userServices.createUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = this.userServices.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
