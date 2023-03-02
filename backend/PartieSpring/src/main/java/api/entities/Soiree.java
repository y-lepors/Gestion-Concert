package api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Soiree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_soiree")
	private Long idSoiree;
	private String nom;

	@ManyToOne
	@JoinColumn(name = "id_salle")
	@JsonBackReference(value = "salle-soiree")
	private Salle salle;

	@OneToMany(mappedBy = "soiree", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "soiree-concert")
	private List<Concert> concerts;
}