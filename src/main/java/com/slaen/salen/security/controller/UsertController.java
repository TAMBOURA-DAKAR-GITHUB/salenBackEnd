package com.slaen.salen.security.controller;

import com.slaen.salen.security.entites.User;
import com.slaen.salen.security.repository.UserRepository;
import com.slaen.salen.security.service.AddRoleToUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class UsertController {

    private AddRoleToUserService addRoleToUserService;

    private UserRepository userRepository;

    public UsertController(AddRoleToUserService addRoleToUserService, UserRepository userRepository) {
        this.addRoleToUserService = addRoleToUserService;
        this.userRepository = userRepository;
    }

    @GetMapping(value ="/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

}
