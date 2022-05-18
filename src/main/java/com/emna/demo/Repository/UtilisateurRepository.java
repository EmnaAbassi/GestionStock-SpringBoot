package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{

}
