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
@Table(name="ligneCdeClient")
public class LigneCdeClient {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name= "idarticle", nullable = false)
	private Article article;
	
	@ManyToOne
	@JoinColumn(name= "idcommandeclient")
	private CommandeClient commandeClients;
	
	@Column(name="quantite")
	private BigDecimal quantit;
	
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

	public CommandeClient getCommandeClients() {
		return commandeClients;
	}

	public void setCommandeClients(CommandeClient commandeClients) {
		this.commandeClients = commandeClients;
	}

	public BigDecimal getQuantit() {
		return quantit;
	}

	public void setQuantit(BigDecimal quantit) {
		this.quantit = quantit;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public LigneCdeClient() {
		super();
	}

	public LigneCdeClient(Integer id, com.emna.demo.model.Article article,
			com.emna.demo.model.CommandeClient commandeClients, BigDecimal quantit, BigDecimal prixUnitaire) {
		super();
		this.id = id;
		this.article = article;
		this.commandeClients = commandeClients;
		this.quantit = quantit;
		this.prixUnitaire = prixUnitaire;
	}

	@Column(name= "prixunitaire")
	private BigDecimal prixUnitaire;
}
