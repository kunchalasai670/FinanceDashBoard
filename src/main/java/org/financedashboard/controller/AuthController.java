package org.financedashboard.controller;

import org.financedashboard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String token = service.login(
                request.get("email"),
                request.get("password")
        );

        return Map.of("token", token);
    }
}
