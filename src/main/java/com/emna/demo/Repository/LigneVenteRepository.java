package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.LigneVente;



@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {

}
