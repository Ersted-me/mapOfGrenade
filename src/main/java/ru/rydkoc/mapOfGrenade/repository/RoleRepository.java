package ru.rydkoc.mapOfGrenade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rydkoc.mapOfGrenade.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
