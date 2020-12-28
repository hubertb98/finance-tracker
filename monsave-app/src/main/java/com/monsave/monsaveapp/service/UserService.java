package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.domain.User;
import com.monsave.monsaveapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(final User user) {
        return repository.save(user);
    }

    public Optional<User> getUser(final Long id) {
        return repository.findById(id);
    }

    public void removeUser(final Long id) {
        repository.deleteById(id);
    }
}
