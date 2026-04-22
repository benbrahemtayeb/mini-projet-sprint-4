package com.tayeb.joueurs.service;

import com.tayeb.joueurs.entities.Role;
import com.tayeb.joueurs.entities.User;

public interface UserService {
    void deleteAllUsers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
}