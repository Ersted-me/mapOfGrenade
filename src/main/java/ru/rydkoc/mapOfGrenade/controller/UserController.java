package ru.rydkoc.mapOfGrenade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.rydkoc.mapOfGrenade.model.User;
import ru.rydkoc.mapOfGrenade.service.impl.UserServiceImpl;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/new")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void register(@RequestBody User user){
        userService.register(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
