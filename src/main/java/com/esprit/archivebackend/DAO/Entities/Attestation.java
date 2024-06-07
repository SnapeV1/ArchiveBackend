package com.esprit.archivebackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAttesttation;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate repoDate;
    String attesttationImage;
    String contact;
    String entreprise;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    Stagiaire stagiaire;

}
