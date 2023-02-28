package com.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;

    private String nom;
    private int nombrePlaces;
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "idGestionnaire")
    private Gestionnaire gestionnaire;

    public Salle(String nom, int nombrePlaces, String adresse) {
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.adresse = adresse;
    }
}

