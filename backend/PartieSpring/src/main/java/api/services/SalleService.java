package api.services;

import api.dtos.SalleDTO;
import api.entities.Salle;
import api.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 Cette classe sert de service pour l'objet Salle. Elle permet de faire le lien entre le contrôleur et le repository
 tout en réalisant des opérations de conversion entre les objets DTO et Entity.
 */
@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    /**
     Cette méthode permet de créer une salle en utilisant un objet DTO et de la sauvegarder en utilisant le repository.
     @param salleDTO L'objet DTO contenant les informations de la salle à créer.
     @return L'objet Entity de la salle créée.
     */
    public Salle createSalle(SalleDTO salleDTO) {
        Salle salle = convertToEntity(salleDTO);
        return salleRepository.save(salle);
    }

    /**
     Cette méthode permet de récupérer une salle en utilisant son identifiant et en utilisant le repository.
     @param idSalle L'identifiant de la salle à récupérer.
     @return L'objet Entity de la salle récupérée.
     @throws EntityNotFoundException Si la salle n'a pas été trouvée avec l'identifiant donné.
     */
    public Salle getSalle(Long idSalle) {
        return salleRepository.findById(idSalle)
                .orElseThrow(() -> new EntityNotFoundException("Salle not found with id: " + idSalle));
    }

    /**
        Cette méthode permet de mettre à jour une salle en utilisant son identifiant et en utilisant le repository.
        @param idSalle L'identifiant de la salle à mettre à jour.
        @param salleDTO L'objet DTO contenant les informations de la salle à mettre à jour.
        @return L'objet Entity de la salle mise à jour.
     */
    public Salle updateSalle(Long idSalle, SalleDTO salleDTO) {
        Salle salle = convertToEntity(salleDTO);
        salle.setIdSalle(idSalle);
        return salleRepository.save(salle);
    }

    /**
     * Cette méthode permet de supprimer une salle en utilisant son identifiant et en utilisant le repository.
     * @param idSalle L'identifiant de la salle à supprimer.
     */
    public void deleteSalle(Long idSalle) {
        salleRepository.deleteById(idSalle);
    }

    /**
     * Cette méthode permet de convertir un objet DTO en objet Entity.
     * @param salleDTO L'objet DTO à convertir.
     * @return L'objet Entity converti.
     */
    public Salle convertToEntity(SalleDTO salleDTO) {
        Salle salle = new Salle(salleDTO.getIdSalle(),salleDTO.getNom(),  salleDTO.getAdresse(), salleDTO.getCapacite(), salleDTO.getSoirees(),salleDTO.getConcerts(), salleDTO.getGestionnaire());
        salle.setGestionnaire(salleDTO.getGestionnaire());
        return salle;
    }

    /**
     * Cette méthode permet de convertir un objet Entity en objet DTO.
     * @param salle L'objet Entity à convertir.
     * @return L'objet DTO converti.
     */
    public SalleDTO convertToDTO(Salle salle) {
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setIdSalle(salle.getIdSalle());
        salleDTO.setNom(salle.getNom());
        salleDTO.setAdresse(salle.getAdresse());
        salleDTO.setCapacite(salle.getCapacite());
        salleDTO.setSoirees(salle.getSoirees());
        salleDTO.setConcerts(salle.getConcerts());
        salleDTO.setGestionnaire(salle.getGestionnaire());

        return salleDTO;
    }
}
