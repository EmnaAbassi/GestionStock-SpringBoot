package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.CommandeFournisseur;


@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer>{

}
