package api.services;

import api.dtos.SalleDTO;
import api.entities.Salle;
import api.mappers.SalleMapper;
import api.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 Cette classe sert de service pour l'objet Salle. Elle permet de faire le lien entre le contrôleur et le repository
 tout en réalisant des opérations de conversion entre les objets DTO et Entity.
 */
@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private SalleMapper salleMapper;

    /**
     Cette méthode permet de récupérer toutes les salles.
     @return La liste des objets Entity des salles récupérées.
     */
    public List<SalleDTO> getAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return salles.stream().map(salle -> salleMapper.toDTO(salle)).collect(Collectors.toList());
    }

    /**
     Cette méthode permet de créer une salle en utilisant un objet DTO et de la sauvegarder en utilisant le repository.
     @param salleDTO L'objet DTO contenant les informations de la salle à créer.
     @return L'objet Entity de la salle créée.
     */
    public SalleDTO saveSalle(SalleDTO salleDTO) {
        Salle salle = salleMapper.toEntity(salleDTO);
        salle = salleRepository.save(salle);
        return salleMapper.toDTO(salle);
    }

    /**
     Cette méthode permet de récupérer une salle en utilisant son identifiant et en utilisant le repository.
     @param id L'identifiant de la salle à récupérer.
     @return L'objet Entity de la salle récupérée.
     @throws EntityNotFoundException Si la salle n'a pas été trouvée avec l'identifiant donné.
     */
    public SalleDTO getSalleById(Long id) {
        Salle salle = salleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleMapper.toDTO(salle);
    }

    /**
        Cette méthode permet de mettre à jour une salle en utilisant son identifiant et en utilisant le repository.
        @param salleDTO L'objet DTO contenant les informations de la salle à mettre à jour.
     */
    public void updateSalle(SalleDTO salleDTO) {
        Optional<Salle> oldSalle = salleRepository.findById(salleDTO.getIdSalle());
        if (oldSalle.isEmpty()) throw new EntityNotFoundException("Salle not found");
        Salle salle = oldSalle.get();
        salle.setConcerts(salleDTO.getConcerts());
        salle.setNom(salleDTO.getNom());
        salle.setAdresse(salleDTO.getAdresse());
        salle.setCapacite(salleDTO.getCapacite());
        salle.setGestionnaire(salleDTO.getGestionnaire());
        salle.setSoirees(salleDTO.getSoirees());
        salleRepository.save(salle);
    }

    /**
     * Cette méthode permet de supprimer une salle en utilisant son identifiant et en utilisant le repository.
     * @param id L'identifiant de la salle à supprimer.
     */
    public boolean deleteSalle(Long id) {
        salleRepository.deleteById(id);
        return true;
    }
}
