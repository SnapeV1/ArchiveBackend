package com.esprit.archivebackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stagiaire {
    @Id
    String identifiant;
    String nom;
    String prenom;
    @OneToMany(mappedBy = "stagiaire", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Attestation> attestations=new ArrayList<>();

}
