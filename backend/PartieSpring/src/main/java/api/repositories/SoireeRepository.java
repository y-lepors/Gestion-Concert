package api.repositories;

import api.entities.Soiree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoireeRepository extends JpaRepository<Soiree, Long> {
}
