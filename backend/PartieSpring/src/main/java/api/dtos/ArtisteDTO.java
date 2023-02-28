package api.dtos;

import lombok.Data;

@Data
public class ArtisteDTO {
	
	private Integer idArtiste;
	private String nom;
	private String prenom;
	private String pseudo;
	private String ville;
	private Integer age;
}
