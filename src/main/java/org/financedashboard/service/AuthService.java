package org.financedashboard.service;

import org.financedashboard.entity.User;
import org.financedashboard.repository.UserRepository;
import org.financedashboard.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String password) {

        User user = repo.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(email);
    }
}
