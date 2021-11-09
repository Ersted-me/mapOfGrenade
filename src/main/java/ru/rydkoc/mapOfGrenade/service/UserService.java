package ru.rydkoc.mapOfGrenade.service;

import ru.rydkoc.mapOfGrenade.model.User;

import java.util.List;

public interface UserService {
    User register(User user);

    User findByEmail(String email);

    User findById(Long id);

    List<User> getAll();

    void delete(Long id);
}
