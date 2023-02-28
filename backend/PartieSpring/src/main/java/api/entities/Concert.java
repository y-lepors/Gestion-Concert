package api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "concert")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConcert;

	private LocalDate dateConcert;

	private Long duree;

	@ManyToOne
	@JoinColumn(name = "idSoiree")
	@JsonBackReference
	private Soiree soiree;

	@ManyToOne
	@JoinColumn(name = "idSalle")
	@JsonBackReference
	private Salle salle;
}

