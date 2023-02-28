package com.dtos;

import com.entities.TypeGestionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionnaireDTO {
    /**
     * Identifiant unique du gestionnaire.
     */
    private Long idGestionnaire;

    /**
     * Nom du gestionnaire.
     */
    private String nom;

    /**
     * Nom du président du gestionnaire.
     */
    private String president;

    /**
     * Type de gestionnaire (personne ou association).
     */
    private TypeGestionnaire typeGestionnaire;
}