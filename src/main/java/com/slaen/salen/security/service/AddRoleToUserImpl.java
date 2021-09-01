package com.slaen.salen.security.service;

import com.slaen.salen.security.entites.Role;
import com.slaen.salen.security.entites.User;
import com.slaen.salen.security.repository.RoleRepository;
import com.slaen.salen.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddRoleToUserImpl implements AddRoleToUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public AddRoleToUserImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addUtilisateur(User utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public Role addRoles(Role roles) {
        return roleRepository.save(roles);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRolesUser(String username, String roles) {

        User u = userRepository.findByUsername(username);
        Role r = roleRepository.findByRole(roles);
        u.getRoles().add(r);
        userRepository.save(u);

    }
}
