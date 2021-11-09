package ru.rydkoc.mapOfGrenade.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rydkoc.mapOfGrenade.model.Role;
import ru.rydkoc.mapOfGrenade.model.Status;
import ru.rydkoc.mapOfGrenade.model.User;
import ru.rydkoc.mapOfGrenade.repository.RoleRepository;
import ru.rydkoc.mapOfGrenade.repository.UserRepository;
import ru.rydkoc.mapOfGrenade.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    public User findByEmail(String email) {
        User resultUser = userRepository.findUserByEmail(email);
        log.info("IN findByEmail - user: {} found by email: {}", resultUser, email);
        return resultUser;
    }

    public User findById(Long id) {
        User resultUser = userRepository.findById(id).orElse(null);

        if(resultUser == null){
            log.warn("IN findById - no user found by Id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by Id: {}", resultUser, id);

        return resultUser;
    }

    public List<User> getAll() {
        List<User> resultUsers = userRepository.findAll();
        log.info("IN getAll - {} users found", resultUsers.size());
        return resultUsers;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}
