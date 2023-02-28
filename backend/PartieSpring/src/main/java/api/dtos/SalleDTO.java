package api.dtos;

import api.entities.Concert;
import api.entities.Gestionnaire;
import api.entities.Soiree;
import lombok.Data;

import java.util.List;

@Data
public class SalleDTO {
	private Long idSalle;
	private String nom;
	private String adresse;
	private Long capacite;
	private List<Soiree> soirees;
	private List<Concert> concerts;
	private Gestionnaire gestionnaire;
}