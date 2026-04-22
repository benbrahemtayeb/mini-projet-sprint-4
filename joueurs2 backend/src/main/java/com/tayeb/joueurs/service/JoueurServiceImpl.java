package com.tayeb.joueurs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tayeb.joueurs.entities.Equipe;
import com.tayeb.joueurs.entities.Joueur;
import com.tayeb.joueurs.repos.EquipeRepository;
import com.tayeb.joueurs.repos.JoueurRepository;

@Service
public class JoueurServiceImpl implements JoueurService {

    @Autowired
    JoueurRepository joueurRepository;

    @Autowired
    EquipeRepository equipeRepository;
    
    @Override
    public Joueur saveJoueur(Joueur p) { return joueurRepository.save(p); }

    @Override
    public Joueur updateJoueur(Joueur p) { return joueurRepository.save(p); }

    @Override
    public void deleteJoueur(Joueur p) { joueurRepository.delete(p); }

    @Override
    public void deleteJoueurById(Long id) { joueurRepository.deleteById(id); }

    @Override
    public Joueur getJoueur(Long id) { return joueurRepository.findById(id).get(); }

    @Override
    public List<Joueur> getAllJoueurs() { return joueurRepository.findAll(); }

    @Override
    public Page<Joueur> getAllJoueursParPage(int page, int size) {
        return joueurRepository.findAll(PageRequest.of(page, size));
    }
    @Override
    public List<Joueur> findByNomJoueur(String nom) {
    	return joueurRepository.findByNomJoueur(nom);
    }
    @Override
    public List<Joueur> findByNomJoueurContains(String nom) {
    	return joueurRepository.findByNomJoueurContains(nom);
    }
    @Override
    public List<Joueur> findByNomPrix(String nom, Double prix) {
    	return joueurRepository.findByNomPrix(nom, prix);
    }
    @Override
    public List<Joueur> findByEquipe(Equipe equipe) {
    	return joueurRepository.findByEquipe(equipe);
    }
    @Override
    public List<Joueur> findByEquipeIdCat(Long id) {
    	return joueurRepository.findByEquipeIdEquipe(id);
    }
    @Override
    public List<Joueur> findByOrderByNomJoueurAsc() {
    	return joueurRepository.findByOrderByNomJoueurAsc();
    }
    @Override
	public List<Joueur> findByEquipeIdEquipe(Long id) {
		return joueurRepository.findByEquipeIdEquipe(id);
	}
    @Override
    public List<Joueur> trierJoueursNomsPrix() {
    	return joueurRepository.trierJoueursNomsPrix();
    }
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }
}