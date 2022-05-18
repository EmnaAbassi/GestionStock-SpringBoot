package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="fournisseur")
public class Fournisseur {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	private String adresse1;
	private String adresse2;
	private String ville;
	private String codePostale;
	
	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public Fournisseur(Integer id, String nom, String prenom, String adresse1, String adresse2, String ville,
			String codePostale, String photo, String mail, String numTel,
			List<CommandeFournisseur> commandeFournisseurs, List<LigneCommandeFournisseur> lignecommandefournisseur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.ville = ville;
		this.codePostale = codePostale;
		this.photo = photo;
		this.mail = mail;
		this.numTel = numTel;
		this.commandeFournisseurs = commandeFournisseurs;
		this.lignecommandefournisseur = lignecommandefournisseur;
	}



	@Column(name="photo")
	private String photo;
	
	@Column(name="mail")
	private String mail;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}

	public List<LigneCommandeFournisseur> getLignecommandefournisseur() {
		return lignecommandefournisseur;
	}

	public void setLignecommandefournisseur(List<LigneCommandeFournisseur> lignecommandefournisseur) {
		this.lignecommandefournisseur = lignecommandefournisseur;
	}

	public Fournisseur() {
		super();
	}

	

	@Column(name="numTel")
	private String numTel;
	
	@OneToMany(mappedBy="fournisseur")
	@JsonBackReference
	private List <CommandeFournisseur> commandeFournisseurs;
	
	@OneToMany(mappedBy = "commandeFournisseurs")
	private List <LigneCommandeFournisseur> lignecommandefournisseur;
}
