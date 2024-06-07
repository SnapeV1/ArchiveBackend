package com.esprit.archivebackend.DAO.Repositories;

import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StagiareRepository extends JpaRepository<Stagiaire, String> {
    Set<Stagiaire> findStagiairesByIdentifiantContainingIgnoreCase(String id);
    Set<Stagiaire> findStagiairesByNomContainingIgnoreCase(String nom);
    Set<Stagiaire> findStagiairesByPrenomContainingIgnoreCase(String prenom);
    boolean existsByIdentifiant(String id);
}
