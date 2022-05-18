package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TypeMvtStk")
public class TypeMvtStock {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="typeMvt")
	private List <MvtStock> mvtStock;

	public TypeMvtStock(Integer id, String nom, List<MvtStock> mvtStock) {
		super();
		this.id = id;
		this.nom = nom;
		this.mvtStock = mvtStock;
	}

	public TypeMvtStock() {
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

	public List<MvtStock> getMvtStock() {
		return mvtStock;
	}

	public void setMvtStock(List<MvtStock> mvtStock) {
		this.mvtStock = mvtStock;
	}
	
	
	
	
	
}
