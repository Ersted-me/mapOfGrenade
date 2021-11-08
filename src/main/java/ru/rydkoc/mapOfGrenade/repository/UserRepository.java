package ru.rydkoc.mapOfGrenade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rydkoc.mapOfGrenade.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
