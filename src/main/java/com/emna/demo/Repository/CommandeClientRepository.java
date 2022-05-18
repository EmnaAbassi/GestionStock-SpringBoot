package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.CommandeClient;


@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer>{

}
