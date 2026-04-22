package com.tayeb.joueurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayeb.joueurs.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>{

}
