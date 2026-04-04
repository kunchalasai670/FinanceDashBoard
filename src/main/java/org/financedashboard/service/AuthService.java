package org.financedashboard.service;

import org.financedashboard.entity.UserEntity;
import org.financedashboard.model.User;
import org.financedashboard.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String password) {

        User user = userService.getByEmail(email); //use Entity

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        // pass role to JWT
        return jwtUtil.generateToken(email, user.getRole().name());
    }
}
