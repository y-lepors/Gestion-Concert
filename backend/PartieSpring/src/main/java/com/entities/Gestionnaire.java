package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gestionnaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire {
    /**
     * Identifiant unique du gestionnaire.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private TypeGestionnaire typeGestionnaire;
}

