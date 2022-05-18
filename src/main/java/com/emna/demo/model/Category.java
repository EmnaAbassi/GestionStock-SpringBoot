package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue
	private Integer id;
	
	
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

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public Category() {
		super();
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

	public Category(Integer id, String code, String description, List<Article> article,
			List<CommandeClient> commandeClients, List<CommandeFournisseur> commandeFournisseurs) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.article = article;
		this.commandeClients = commandeClients;
		this.commandeFournisseurs = commandeFournisseurs;
	}





	@Column(name = "code")
	private String code;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy="idcategory")
	//l'annotation ely 5dmt afficage fl article
	@JsonBackReference

	private List <Article> article;
	
	
	@OneToMany(mappedBy="category")
	@JsonBackReference
	private List <CommandeClient> commandeClients;	
	
	
	@OneToMany(mappedBy="category")
	@JsonBackReference
	private List <CommandeFournisseur> commandeFournisseurs;	
	
	
}
