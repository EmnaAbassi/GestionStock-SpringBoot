package com.emna.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="Commandefournisseur")
@Entity
public class CommandeFournisseur {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name= "code")
	private String code;
	
	@Column(name= "datedecommande")
	private Date dateDeCommande;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateDeCommande() {
		return dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public CommandeFournisseur() {
		super();
	}

	

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CommandeFournisseur(Integer id, String code, Date dateDeCommande, Fournisseur fournisseur, Article article,
			Category category) {
		super();
		this.id = id;
		this.code = code;
		this.dateDeCommande = dateDeCommande;
		this.fournisseur = fournisseur;
		this.article = article;
		this.category = category;
	}



	@ManyToOne
	@JoinColumn(name= "idfournisseur")
	private Fournisseur fournisseur;
	
	@ManyToOne
	@JoinColumn( name = "idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn( name = "idcategory")
	private Category category;
	
}
