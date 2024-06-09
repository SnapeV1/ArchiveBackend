package com.esprit.archivebackend.Services;


import com.esprit.archivebackend.DAO.Entities.Attestation;
import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IServices {
    public Set<Attestation> getAttestationByIdentifiant(String id);
    public Set<Attestation> getAttestationByRepoDate(LocalDate date);
    public Set<Attestation> getAttestationByStartDate(LocalDate date);
    public Set<Attestation> getAttestationByEndDate(LocalDate date);
    public Set<Attestation> getAttestationByStagiaireNom(String nom);
    public Set<Attestation> getAttestationByStagiairePrenom(String prenom);
    public Attestation addAtesttation(Attestation attestation);
    public Set<String> getAllEntreprise();
    public void removeAttestation(long idAtt);
    public void updateAttestationImage(long idAtt, MultipartFile attestationImage);
    public String getAttestationImage(long idAtt);

    Stagiaire addStagiare(Stagiaire stagiaire);
    List<Stagiaire> getAllStagiares();



}
