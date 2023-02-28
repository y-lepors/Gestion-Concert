package com.dtos;

import com.entities.Gestionnaire;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalleDTO {
    private Long idSalle;
    private String nom;
    private int nombrePlaces;
    private String adresse;
    private Gestionnaire gestionnaire;

    public SalleDTO(String nom, int nombrePlaces, String adresse, Gestionnaire gestionnaire) {
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.adresse = adresse;
        this.gestionnaire = gestionnaire;
    }
}
