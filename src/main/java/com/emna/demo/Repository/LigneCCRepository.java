package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.LigneCdeClient;


@Repository
public interface LigneCCRepository extends JpaRepository<LigneCdeClient,Integer>{

}
