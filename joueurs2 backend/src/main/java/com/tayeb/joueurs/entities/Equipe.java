package com.tayeb.joueurs.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	private String nomEquipe;
	private String descriptionEquipe;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipe")
	private List<Joueur> joueurs;
	public Equipe(String nomEquipe, String descriptionEquipe, List<Joueur> joueurs) {
		super();
		this.nomEquipe = nomEquipe;
		this.descriptionEquipe = descriptionEquipe;
		this.joueurs = joueurs;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getDescriptionEquipe() {
		return descriptionEquipe;
	}
	public void setDescriptionEquipe(String descriptionEquipe) {
		this.descriptionEquipe = descriptionEquipe;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
		
}
