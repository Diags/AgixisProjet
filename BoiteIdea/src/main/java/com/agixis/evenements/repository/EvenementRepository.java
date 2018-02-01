package com.agixis.evenements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agixis.evenements.entities.Evenement;

@Repository
public interface EvenementRepository  extends JpaRepository<Evenement,Long> {
}
