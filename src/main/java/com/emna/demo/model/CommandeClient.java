package com.emna.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="commandeclient")
public class CommandeClient {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name= "code")
	private String code;
	
	@Column(name= "datedecommande")
	private Date dateDeCommande;
	
	
	@ManyToOne
	@JoinColumn( name = "idclient")
	private Client client;
  
	
	@ManyToOne
	@JoinColumn( name = "idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn( name = "idcategory")
	private Category category;

	


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


	public CommandeClient(Integer id, String code, Date dateDeCommande, Client client, Article article,
			Category category) {
		super();
		this.id = id;
		this.code = code;
		this.dateDeCommande = dateDeCommande;
		this.client = client;
		this.article = article;
		this.category = category;
	}


	public CommandeClient() {
		super();
	}


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


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
