package com.emna.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="rolename")
	private String roleName;
	
/*	@OneToMany(mappedBy="role")
	private List <Utilisateur> user;*/

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
		//this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/*public List<Utilisateur> getUser() {
		return user;
	}*/

	public Role() {
		super();
	}

	/*public void setUser(List<Utilisateur> user) {
		this.user = user;}*/
	
	
	
	
	
}
