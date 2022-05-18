package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="utitlisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="NumTel")
	private String numTel;
	
	@Column(name="motdepasse")
	private String motDePasse;
	
	@Column(name = "adresse1")
	private String adresse1;
	
	@Column(name = "adresse2")
	private String adresse2;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "codePostale")
	private String codePostale;
	/*@Embedded
	private adresse adress;*/
	
	/*@Column(name="photo")
	private String photo;*/
	
/*	public Utilisateur(Integer id, String nom, String prenom, String email, String dateDeNaissance, String motDePasse,
			adresse adress, String photo, Entreprise entreprise, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
		this.adress = adress;
	    this.photo = photo;
		this.entreprise = entreprise;
		this.role = role;}*/
	

/*	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;}*/
	
//na7it les annotaions hdhoum bch n5dmouha table aadiya 
	/*@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;

	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;*/
	
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
*/
	public String getMotDePasse() {
		return motDePasse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

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

	public Utilisateur(Integer id, String nom, String prenom, String email, String numTel, String motDePasse,
		String adresse1, String adresse2, String ville, String codePostale) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numTel = numTel;
	this.motDePasse = motDePasse;
	this.adresse1 = adresse1;
	this.adresse2 = adresse2;
	this.ville = ville;
	this.codePostale = codePostale;
}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/*public adresse getAdress() {
		return adress;
	}

	public void setAdress(adresse adress) {
		this.adress = adress;
	}*/

/*	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}*/

	
	public Utilisateur() {
		super();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
