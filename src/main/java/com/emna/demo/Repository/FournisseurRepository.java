package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.Fournisseur;


@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer>{

}
