package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.TypeMvtStock;


@Repository
public interface TypeMvtStockRepository extends JpaRepository<TypeMvtStock,Integer> {

}
