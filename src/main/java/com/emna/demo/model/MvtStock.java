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
@Table(name="MvtStock")

public class MvtStock {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="datemvt")
	private Date dateMvt;
	
	@Column(name="quantite")
	private String quantite;
	
	
	@ManyToOne
	@JoinColumn(name= "typeMvtStck")
	private TypeMvtStock typeMvt;
	
	@ManyToOne
	@JoinColumn(name= "idarticle")
	private Article article;

	public MvtStock(Integer id, Date dateMvt, String quantite, TypeMvtStock typeMvt, Article article) {
		super();
		this.id = id;
		this.dateMvt = dateMvt;
		this.quantite = quantite;
		this.typeMvt = typeMvt;
		this.article = article;
	}

	public MvtStock() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public TypeMvtStock getTypeMvt() {
		return typeMvt;
	}

	public void setTypeMvt(TypeMvtStock typeMvt) {
		this.typeMvt = typeMvt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
	
	
	
	
	
	
	
}
