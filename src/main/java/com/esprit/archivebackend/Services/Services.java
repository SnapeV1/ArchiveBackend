package com.esprit.archivebackend.Services;

import com.esprit.archivebackend.DAO.Entities.Attestation;
import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import com.esprit.archivebackend.DAO.Repositories.AttestationRepository;
import com.esprit.archivebackend.DAO.Repositories.StagiareRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Services implements IServices {
    StagiareRepository stagiareRepository;
    AttestationRepository attestationRepository;
    @Override
    public Set<Attestation> getAttestationByIdentifiant(String id) {
        Set<Stagiaire> stagiaires=stagiareRepository.findStagiairesByIdentifiantContainingIgnoreCase(id);
        Set<Attestation> attestations=new HashSet<>();
        for(Stagiaire s:stagiaires){

            Set<Attestation> attestationsByStagiaire=attestationRepository.findAttestationsByStagiaire(s);
            attestations.addAll(attestationsByStagiaire);

        }
        return attestations;
    }

    @Override
    public Set<Attestation> getAttestationByRepoDate(LocalDate date) {
        return attestationRepository.findAttestationsByRepoDate(date);
    }

    @Override
    public Set<Attestation> getAttestationByStartDate(LocalDate date) {
        return attestationRepository.findAttestationsByStartDate(date);
    }

    @Override
    public Set<Attestation> getAttestationByEndDate(LocalDate date) {
        return attestationRepository.findAttestationsByEndDate(date);
    }

    @Override
    public Set<Attestation> getAttestationByStagiaireNom(String nom) {
        Set<Stagiaire> stagiaires=stagiareRepository.findStagiairesByNomContainingIgnoreCase(nom);
        Set<Attestation> attestations=new HashSet<>();
        for(Stagiaire s:stagiaires){

            Set<Attestation> attestationsByStagiaire=attestationRepository.findAttestationsByStagiaire(s);
            attestations.addAll(attestationsByStagiaire);

        }
        return attestations;
    }

    @Override
    public Set<Attestation> getAttestationByStagiairePrenom(String prenom) {
        Set<Stagiaire> stagiaires=stagiareRepository.findStagiairesByPrenomContainingIgnoreCase(prenom);
        Set<Attestation> attestations=new HashSet<>();
        for(Stagiaire s:stagiaires){

            Set<Attestation> attestationsByStagiaire=attestationRepository.findAttestationsByStagiaire(s);
            attestations.addAll(attestationsByStagiaire);

        }
        return attestations;
    }

    @Override
    public Attestation addAtesttation(Attestation attestation) {
        if (stagiareRepository.existsByIdentifiant(attestation.getStagiaire().getIdentifiant())){
            Stagiaire stagiaire=stagiareRepository.findById(attestation.getStagiaire().getIdentifiant()).get();
            stagiaire.getAttestations().add(attestation);
            attestation.setStagiaire(stagiaire);
            stagiareRepository.save(stagiaire);
        }
        else {
            attestationRepository.save(attestation);
        }
        return attestation;

    }

    @Override
    public Set<String> getAllEntreprise() {
        Set<String> entrepriseList=new HashSet<>();
        for (Attestation attestation:attestationRepository.findAll()){
            entrepriseList.add(attestation.getEntreprise());
        }
        return entrepriseList;
    }

    @Override
    public void removeAttestation(long idAtt) {
        Attestation att=attestationRepository.findById(idAtt).get();
        att.setStagiaire(null);
        attestationRepository.delete(att);
    }
    Environment environment;
    NameFile fileNamingUtil;
    FileUtil utils;
    @Override
    public void updateAttestationImage(long idAtt, MultipartFile attestationImage) {
        Attestation attestation= attestationRepository.findById(idAtt).get();
        try {
            if (attestationImage != null && !attestationImage.isEmpty() && attestationImage.getSize() > 0) {
                String uploadDir = environment.getProperty("upload.attestation.images");
                String newPhotoName = fileNamingUtil.nameFile(attestationImage);
                attestation.setAttesttationImage(newPhotoName);
                utils.saveNewFile(uploadDir, newPhotoName, attestationImage);
            }
            attestationRepository.save(attestation);
        } catch (IOException e) {
            throw new RuntimeException("Failed to update attestation image", e);
        }
    }

    @Override
    public String getAttestationImage(long idAtt) {
        Attestation attestation=attestationRepository.findById(idAtt).get();
        String baseUrl = environment.getProperty("export.attestation.images");
        String attestationImage = attestation.getAttesttationImage();
        if (attestationImage != null && !attestationImage.isEmpty()) {
            return baseUrl + attestationImage;
        }
        return null;
    }


    public Stagiaire addStagiare(Stagiaire stagiaire){
        return stagiareRepository.save(stagiaire);

    }

}
