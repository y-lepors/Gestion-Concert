package api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "soiree")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Soiree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSoiree;
	private String nom;

	@ManyToOne
	@JoinColumn(name = "idSalle")
	@JsonBackReference
	private Salle salle;

	@OneToMany(mappedBy = "soiree")
	@JsonManagedReference
	private List<Concert> concerts;
}