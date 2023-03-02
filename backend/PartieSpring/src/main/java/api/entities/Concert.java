package api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_concert")
	private Long idConcert;

	@Column(name = "date_concert")
	private LocalDate dateConcert;

	private Long duree;

	@ManyToOne
	@JoinColumn(name = "id_soiree")
	@JsonBackReference(value = "soiree-concert")
	private Soiree soiree;

	@ManyToOne
	@JoinColumn(name = "id_salle")
	@JsonBackReference(value = "salle-concert")
	private Salle salle;
}

