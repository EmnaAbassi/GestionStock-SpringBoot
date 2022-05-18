package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="entreprise")
public class Entreprise {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public Entreprise() {
		super();
	}

	

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public adresse getA() {
		return a;
	}

	public void setA(adresse a) {
		this.a = a;
	}

	public String getCodeFiscal() {
		return codeFiscal;
	}

	public void setCodeFiscal(String codeFiscal) {
		this.codeFiscal = codeFiscal;
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

	@Column(name="nom")
	private String nom;
	
	@Column(name="description")
	private String description;
	
	@Embedded 
	private adresse a;
	
	@Column(name="codefiscal")
	private String codeFiscal;
	
	@Column(name="mail")
	private String mail;
	
	

	/*public List<Utilisateur> getUser() {
		return user;
	}



	public void setUser(List<Utilisateur> user) {
		this.user = user;
	}
*/
	@Column(name="numtel")
	private String numTel;
	
	/*@OneToMany(mappedBy="entreprise")
	private List <Utilisateur> user;*/

	public Entreprise(Integer id, String nom, String description, adresse a, String codeFiscal, String mail,
			String numTel) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.a = a;
		this.codeFiscal = codeFiscal;
		this.mail = mail;
		this.numTel = numTel;
	//this.user = user;
	}

	
	
}
