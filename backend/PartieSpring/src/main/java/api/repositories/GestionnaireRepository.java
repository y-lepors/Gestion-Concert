package api.repositories;

import api.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
}
