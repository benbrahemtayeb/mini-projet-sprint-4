package com.tayeb.joueurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tayeb.joueurs.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}