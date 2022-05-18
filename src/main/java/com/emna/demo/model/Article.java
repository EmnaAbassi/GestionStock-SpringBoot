package com.emna.demo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="article")


public class Article {

	@Id
	@GeneratedValue
	private Integer id;
	
	public Article() {
		
	}



	

	











	public List<CommandeClient> getCommandeClients() {
		return commandeClients;
	}

















	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}





























	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

















	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}

















	public Article(Integer id, String codeArticle, String designation, Integer prixUnitaireHT, Integer tauxTVA,
			Integer prixUnitaireTTC, Category idcategory, List<CommandeClient> commandeClients,
			List<CommandeFournisseur> commandeFournisseurs) {
		super();
		this.id = id;
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.tauxTVA = tauxTVA;
		this.prixUnitaireTTC = prixUnitaireTTC;
		this.idcategory = idcategory;
		this.commandeClients = commandeClients;
		this.commandeFournisseurs = commandeFournisseurs;
	}

















	public Category getIdcategory() {
		return idcategory;
	}








	public void setIdcategory(Category idcategory) {
		this.idcategory = idcategory;
	}








	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getPrixUnitaireHT() {
		return prixUnitaireHT;
	}

	public void setPrixUnitaireHT(Integer prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}

	public Integer getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(Integer tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	
	

	public Integer getPrixUnitaireTTC() {
		return prixUnitaireTTC;
	}

	public void setPrixUnitaireTTC(Integer prixUnitaireTTC) {
		this.prixUnitaireTTC = prixUnitaireTTC;
	}

	

	@Column(name="codeArticle")
	private String codeArticle;
		
	@Column(name="designation")	
	private String designation;
		
	@Column(name="prixUnitaireHT")
	private Integer prixUnitaireHT;

	@Column(name="tauxTVA")
	private Integer tauxTVA;

	@Column(name="prixUnitaireTTC")
	private Integer prixUnitaireTTC;


	
	@ManyToOne
	@JoinColumn(name= "idcategory")
	@JsonIgnore
	private Category idcategory;
	
	
	@OneToMany(mappedBy="article")
	@JsonBackReference
	private List <CommandeClient> commandeClients;	
	
	@OneToMany(mappedBy="article")
	@JsonBackReference
	private List <CommandeFournisseur> commandeFournisseurs;
}
