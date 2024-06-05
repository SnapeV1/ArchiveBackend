package com.esprit.archivebackend.DAO.Repositories;

import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiareRepository extends JpaRepository<Stagiaire, Long> {

}
