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
@Table(name="ligneCdeFournisseur")
public class LigneCommandeFournisseur {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name= "idarticle")
	private Article article;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public CommandeFournisseur getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(CommandeFournisseur commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}

	public LigneCommandeFournisseur() {
		super();
	}

	public LigneCommandeFournisseur(Integer id, Article article, BigDecimal quantite,
			CommandeFournisseur commandeFournisseurs) {
		super();
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.commandeFournisseurs = commandeFournisseurs;
	}

	@Column(name="quantite")
	private BigDecimal quantite;
	
	/*private CommandeFournisseur commandeFournisseurs;*/
	
	@ManyToOne
	@JoinColumn(name= "idcommandeFournisseur")
	private CommandeFournisseur commandeFournisseurs;
	
	
	
	
	
	
}
