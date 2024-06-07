package com.esprit.archivebackend.DAO.Repositories;

import com.esprit.archivebackend.DAO.Entities.Attestation;
import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AttestationRepository extends JpaRepository<Attestation,Long> {
    Set<Attestation> findAttestationsByEntrepriseContainingIgnoreCase(String entreprise);
    Set<Attestation> findAttestationsByRepoDate(LocalDate daterepo);
    Set<Attestation> findAttestationsByStartDate(LocalDate startDatte);
    Set<Attestation> findAttestationsByEndDate(LocalDate endDate);
    Set<Attestation> findAttestationsByStagiaire(Stagiaire stagiaire);

}
