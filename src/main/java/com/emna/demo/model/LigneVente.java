package com.emna.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ligneVente")
public class LigneVente {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="quantite")
	private BigDecimal quantite;
	
	@Column(name="prixunitaire")
	private BigDecimal prixUnitaire;
	
	@ManyToOne
	@JoinColumn(name= "idvente")
	private Ventes vente;

	@ManyToOne
	@JoinColumn(name= "idarticle")
	private Article article;
	
	public LigneVente(Integer id, BigDecimal quantite, BigDecimal prixUnitaire, Ventes vente, Article article) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.vente = vente;
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	

	public LigneVente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Ventes getVente() {
		return vente;
	}

	public void setVente(Ventes vente) {
		this.vente = vente;
	}
	
	
	
	
	
	
}
