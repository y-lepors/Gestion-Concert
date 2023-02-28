package api.dtos;

import api.entities.Concert;
import api.entities.Salle;
import lombok.Data;

import java.util.List;

@Data
public class SoireeDTO {
	private Long idSoiree;
	private String nom;
	private Salle salle;
	private List<Concert> concerts;
}
