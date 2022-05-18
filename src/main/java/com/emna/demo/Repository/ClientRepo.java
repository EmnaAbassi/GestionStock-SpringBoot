package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {

}
