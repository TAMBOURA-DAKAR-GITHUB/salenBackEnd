package com.slaen.salen.security.service;

import com.slaen.salen.security.entites.Role;
import com.slaen.salen.security.entites.User;

import java.util.List;

public interface AddRoleToUserService {
    User addUtilisateur(User utilisateur);
    Role addRoles(Role roles);
    List<User> listUsers();

    void  addRolesUser(String username , String roles);
}
