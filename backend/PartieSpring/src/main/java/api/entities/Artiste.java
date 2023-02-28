package api.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
