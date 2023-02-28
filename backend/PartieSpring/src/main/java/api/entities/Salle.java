package api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Salle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalle;

	private String nom;
	private String adresse;
	private Long capacite;

	@OneToMany(mappedBy = "salle")
	@JsonManagedReference
	private List<Soiree> soirees;

	@OneToMany(mappedBy = "salle")
	@JsonManagedReference
	private List<Concert> concerts;

	@ManyToOne
	@JoinColumn(name = "idGestionnaire")
	@JsonBackReference
	private Gestionnaire gestionnaire;
}
