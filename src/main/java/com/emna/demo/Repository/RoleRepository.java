package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
