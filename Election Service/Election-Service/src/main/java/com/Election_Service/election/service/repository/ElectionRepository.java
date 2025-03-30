package com.Election_Service.election.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Election_Service.election.service.model.Election;

public interface ElectionRepository extends JpaRepository<Election,Long>{
Optional<Election> findByName(String name);
}
