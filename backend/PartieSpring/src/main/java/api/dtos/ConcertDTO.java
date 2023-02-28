package api.dtos;

import api.entities.Salle;
import api.entities.Soiree;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConcertDTO {

	private Long idConcert;
	private LocalDate dateConcert;
	private Long duree;
	private Soiree soiree;
	private Salle salle;
}

