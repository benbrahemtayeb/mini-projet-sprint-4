package com.tayeb.joueurs.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.tayeb.joueurs.entities.Equipe;
import com.tayeb.joueurs.entities.Joueur;

public interface JoueurService {
    Joueur saveJoueur(Joueur p);
    Joueur updateJoueur(Joueur p);
    void deleteJoueur(Joueur p);
    void deleteJoueurById(Long id);
    Joueur getJoueur(Long id);
    List<Joueur> getAllJoueurs();
    Page<Joueur> getAllJoueursParPage(int page, int size);
    List<Joueur> findByNomJoueur(String nom);
    List<Joueur> findByNomJoueurContains(String nom);
    List<Joueur> findByNomPrix (String nom, Double prix);
    List<Joueur> findByEquipe (Equipe equipe);
    List<Joueur> findByEquipeIdCat(Long id);
    List<Joueur> findByOrderByNomJoueurAsc();
    List<Joueur> trierJoueursNomsPrix();
    List<Equipe> getAllEquipes();
    List<Joueur> findByEquipeIdEquipe(Long id);
}