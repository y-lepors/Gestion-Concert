package api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "gestionnaire")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Gestionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGestionnaire;
	private String nom;
	private String president;
	@OneToMany(mappedBy = "gestionnaire")
	@JsonManagedReference
	private List<Salle> salles;
}