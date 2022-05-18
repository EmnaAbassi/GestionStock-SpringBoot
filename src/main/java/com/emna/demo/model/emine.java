package com.emna.demo.model;

public class emine {

	private int id;
	private  int codeArticle;
	private String designation;
	private int prixUnitaireHT;
	private int tauxTVA;
	private int prixUnitaireTTC;
	private int idcategory;
	public emine(int id, int codeArticle, String designation, int prixUnitaireHT, int tauxTVA, int prixUnitaireTTC) {
		super();
		this.id = id;
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.tauxTVA = tauxTVA;
		this.prixUnitaireTTC = prixUnitaireTTC;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrixUnitaireHT() {
		return prixUnitaireHT;
	}
	public void setPrixUnitaireHT(int prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}
	public int getTauxTVA() {
		return tauxTVA;
	}
	public void setTauxTVA(int tauxTVA) {
		this.tauxTVA = tauxTVA;
	}
	public int getPrixUnitaireTTC() {
		return prixUnitaireTTC;
	}
	public void setPrixUnitaireTTC(int prixUnitaireTTC) {
		this.prixUnitaireTTC = prixUnitaireTTC;
	}
	public int getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}
}
