package api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Gestionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gestionnaire")
	private Long idGestionnaire;
	private String nom;
	private String president;
	private String typeGestionnaire;
	@OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "gestionnaire-salle")
	private List<Salle> salles;
}