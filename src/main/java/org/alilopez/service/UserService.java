package org.alilopez.service;

import org.alilopez.model.User;
import org.alilopez.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserRepository userRepo;
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> getAllUsers() throws SQLException {
        return userRepo.findAll();
    }

    public User getByIdUser(int idUser) throws SQLException {
        return userRepo.findByIdUser(idUser);
    }

    public void createUser(User user) throws SQLException {
        // Podrías validar aquí si el email ya existe, etc.
        userRepo.save(user);
    }
}
