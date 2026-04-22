package com.tayeb.joueurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tayeb.joueurs.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}