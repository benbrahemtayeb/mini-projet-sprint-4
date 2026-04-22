package com.tayeb.joueurs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.tayeb.joueurs.entities.Equipe;
import com.tayeb.joueurs.entities.Joueur;
import com.tayeb.joueurs.repos.JoueurRepository;
import com.tayeb.joueurs.service.JoueurService;

@SpringBootTest
class Joueurs2ApplicationTests {
	@Autowired
	private JoueurRepository joueurRepository;
	private JoueurService joueurService;
	@Test
	public void testCreateJoueur() {
		Joueur jou = new Joueur("Tayeb Ben Brahem",50.0,new Date());
		joueurRepository.save(jou);
	}
	@Test
	public void testFindJoueur()
	{
		Joueur p = joueurRepository.findById(1L).get();
		System.out.println(p);
	}
	@Test
	public void testUpdateJoueur()
	{
		Joueur p = joueurRepository.findById(1L).get();
		p.setPrixJoueur(1000.0);
		joueurRepository.save(p);
	}
	@Test
	public void testDeleteJoueur()
	{
		joueurRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousJoueurs()
	{
		List<Joueur> joueurs = joueurRepository.findAll();
		for (Joueur p : joueurs)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomJoueurContains()
	{
		/*Page<Joueur> jous = joueurService.getAllJoueursParPage(0,2);
		System.out.println(jous.getSize());
		System.out.println(jous.getTotalElements());
		System.out.println(jous.getTotalPages());
		jous.getContent().forEach(p -> {System.out.println(p.toString());
		});
		/*ou bien
		for (Joueur p : jous)
		{
			System.out.println(p);
		} */
		List<Joueur> joueurs=joueurRepository.findByNomJoueurContains("Messi");
		for (Joueur p : joueurs)
		{
			System.out.println(p);
		} 

	}
	@Test
	public void testFindByNomjoueur()
	{
		List<Joueur> joueurs = joueurRepository.findByNomJoueur("Salah");
		for (Joueur j : joueurs)
		{
			System.out.println(j);
		}
	}
	@Test
	public void testfindByEquipe()
	{
		Equipe eqp = new Equipe();
		eqp.setIdEquipe(1L);
		List<Joueur> joueurs = joueurRepository.findByEquipe(eqp);
		for (Joueur j : joueurs)
		{
			System.out.println(j);
		}
	}
	@Test
	public void findByEquipeIdEquipe()
	{
		List<Joueur> joueurs = joueurRepository.findByEquipeIdEquipe(2L);
		for (Joueur j : joueurs)
		{
			System.out.println(j);
		}
	}
	@Test
	public void testfindByOrderByNomJoueurAsc()
	{
		List<Joueur> joueurs =
				joueurRepository.findByOrderByNomJoueurAsc();
		for (Joueur j : joueurs)
		{
			System.out.println(j);
		}
	}
	@Test
	public void testTrierJoueursNomsPrix()
	{
		List<Joueur> joueurs = joueurRepository.trierJoueursNomsPrix();
		for (Joueur j: joueurs)
		{
			System.out.println(j);
		}
	}
}
