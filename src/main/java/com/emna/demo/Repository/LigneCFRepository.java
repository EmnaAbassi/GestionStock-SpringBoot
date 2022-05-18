package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.LigneCommandeFournisseur;


@Repository
public interface LigneCFRepository extends JpaRepository<LigneCommandeFournisseur,Integer>{

}
