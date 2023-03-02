package api.dtos;

import api.entities.Salle;
import lombok.Data;

import java.util.List;

@Data
public class GestionnaireDTO {
	private Long idGestionnaire;
	private String nom;
	private String president;
	private String typeGestionnaire;
	private List<Salle> salles;
}
