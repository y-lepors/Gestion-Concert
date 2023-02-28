package com.repositories;

import com.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Cette interface représente le repository GestionnaireRepository pour l'entité Gestionnaire.
 */
@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
}
