package com.emna.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class adresse {
	@Column(name = "adresse1")
	private String adresse1;
	
	@Column(name = "adresse2")
	private String adresse2;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "codePostale")
	private String codePostale;

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public adresse(String adresse1, String adresse2, String ville, String codePostale) {
		
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.ville = ville;
		this.codePostale = codePostale;
	}

	public adresse() {
		
	}
	
}

