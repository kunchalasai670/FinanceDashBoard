package org.financedashboard.controller;

import org.financedashboard.entity.UserEntity;
import org.financedashboard.model.User;
import org.financedashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //Register user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.save(user);
    }

    //Get user by email
    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        return service.getByEmail(email);
    }
}
