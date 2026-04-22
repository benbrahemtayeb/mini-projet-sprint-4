package com.tayeb.joueurs.entities;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJoueur;
	
	@NotBlank(message = "Le nom ne doit pas être vide")
	@Size(min = 4, max = 15)
	private String nomJoueur;
	
	@DecimalMin(value = "0.1")
	@DecimalMax(value = "1000.0")
	private Double prixJoueur;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateTransfert;
	@ManyToOne
	private Equipe equipe;
	
	public Joueur() {
		super();
	}
	public Joueur(String nomJoueur, Double prixJoueur, Date dateTransfert) {
		super();
		this.nomJoueur = nomJoueur;
		this.prixJoueur = prixJoueur;
		this.dateTransfert = dateTransfert;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe=equipe;
	}
	public Long getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public Double getPrixJoueur() {
		return prixJoueur;
	}
	public void setPrixJoueur(Double prixJoueur) {
		this.prixJoueur = prixJoueur;
	}
	public Date getDateTransfert() {
		return dateTransfert;
	}
	public void setDateTransfert(Date dateTransfert) {
		this.dateTransfert = dateTransfert;
	}
	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" +
		nomJoueur + ", prixJoueur=" + prixJoueur
		+ ", dateTransfert=" + dateTransfert + "]";
	}
}

