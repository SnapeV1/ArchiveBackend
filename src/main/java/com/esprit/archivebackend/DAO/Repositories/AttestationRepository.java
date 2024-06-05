package com.esprit.archivebackend.DAO.Repositories;

import com.esprit.archivebackend.DAO.Entities.Attestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttestationRepository extends JpaRepository<Attestation,Long> {


}
