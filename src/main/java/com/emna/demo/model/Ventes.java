package com.emna.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vente")
public class Ventes {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name= "code")
	private String code;
	
	@Column(name= "datevente")
	private Date dateVente;
	
	@Column(name= "commentaire")
	private String commentaire;
	
	@OneToMany(mappedBy="vente")
	private List <LigneVente> lv;

	public Ventes(Integer id, String code, Date dateVente, String commentaire) {
		super();
		this.id = id;
		this.code = code;
		this.dateVente = dateVente;
		this.commentaire = commentaire;
	}

	public Ventes() {
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

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	

}
