package api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Salle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salle")
	private Long idSalle;

	private String nom;
	private String adresse;
	private Long capacite;

	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "salle-soiree")
	private List<Soiree> soirees;

	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "salle-concert")
	private List<Concert> concerts;

	@ManyToOne
	@JoinColumn(name = "id_gestionnaire")
	@JsonBackReference(value = "gestionnaire-salle")
	private Gestionnaire gestionnaire;
}
