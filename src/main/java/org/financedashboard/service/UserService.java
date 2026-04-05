package org.financedashboard.service;

import org.financedashboard.dto.UserDTO;
import org.financedashboard.entity.Role;
import org.financedashboard.entity.UserEntity;
import org.financedashboard.model.User;
import org.financedashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserDTO mapper = UserDTO.INSTANCE;

    public User getByEmail(String email) {
        return mapper.toUserModel(repo.findByEmail(email));
    }

    public User save(User user) {
        UserEntity userEntity = mapper.toUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userEntity.getRole() == null) {
            userEntity.setRole(Role.ROLE_VIEWER);
        }
        userEntity.setActive(true);
        UserEntity result = repo.save(userEntity);
        return mapper.toUserModel(result);
    }
}