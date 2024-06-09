package com.esprit.archivebackend.Controllers;

import com.esprit.archivebackend.DAO.Entities.Attestation;
import com.esprit.archivebackend.DAO.Entities.Stagiaire;
import com.esprit.archivebackend.Services.IServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@CrossOrigin("*")
public class RestController{
    IServices services;
    @PostMapping("AddAttestation")
    public Attestation addAttestation(@RequestBody Attestation attestation){
        return services.addAtesttation(attestation);
    }
    @GetMapping("AttestationByIdentifiant/{id}")
    public Set<Attestation> getAttestationByIdentifiant(@PathVariable("id") String id){
        return services.getAttestationByIdentifiant(id);
    }
    @GetMapping("AttestationByDateRepo/{id}")
    public Set<Attestation> getAttestationByRepoDate(@PathVariable("id") LocalDate date){
        return services.getAttestationByRepoDate(date);
    }
    @GetMapping("AttestationByStartDate/{id}")
    public Set<Attestation> getAttestationByStartDate(@PathVariable("id") LocalDate date){
        return services.getAttestationByRepoDate(date);
    }
    @GetMapping("AttestationByEndDate/{id}")
    public Set<Attestation> getAttestationByEndDate(@PathVariable("id") LocalDate date){
        return services.getAttestationByRepoDate(date);
    }
    @GetMapping("AttestationByStagiaireNom/{id}")
    public Set<Attestation> getAttestationByStagiaireNom(@PathVariable("id") String nom){
        return  services.getAttestationByStagiaireNom(nom);
    }
    @GetMapping("AttestationByStagiairePrenom/{id}")
    public Set<Attestation> getAttestationByStagiairePrenom(@PathVariable("id") String prenom){
        return services.getAttestationByStagiairePrenom(prenom);
    }
    @GetMapping("AllEntreprises")
    public Set<String> getAllEntreprieses(){
        return services.getAllEntreprise();
    }
    @DeleteMapping("removeAtt/{id}")
    public void removeAtt(@PathVariable("id")long id){
         services.removeAttestation(id);
    }
    @PostMapping("uploadAttestationImage/image/{id}")
    public void updateCompetitionImage(@PathVariable("id")long idAtt, @RequestParam("image") MultipartFile image){
         services.updateAttestationImage(idAtt,image);
    }
    @GetMapping("getAttestationImage/{id}")
    public String getCompetitionImage(@PathVariable("id")long idAtt){
        return services.getAttestationImage(idAtt);
    }




    //Stagiare

    @PostMapping("addStagiare")
    public Stagiaire addStagiare(@RequestBody Stagiaire stagiaire){
        return services.addStagiare(stagiaire);
    }


    @GetMapping("getStagiares")
    public List<Stagiaire> GetAllStagiares(){
        return services.getAllStagiares();
    }




}

