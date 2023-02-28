package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArtiste;
	private String nom;
	private String prenom;
	private String pseudo;
	private String ville;
	private Integer age;
}
