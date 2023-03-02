package api.services;

import api.dtos.GestionnaireDTO;
import api.entities.Gestionnaire;
import api.mappers.GestionnaireMapper;
import api.repositories.GestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Cette classe représente le service GestionnaireService qui contient la logique métier de l'entité Gestionnaire.
 */
@Service
@Transactional
public class GestionnaireService {

    @Autowired
    private GestionnaireRepository gestionnaireRepository;
    @Autowired
    private GestionnaireMapper gestionnaireMapper;

    /**
     Cette méthode permet de récupérer tous les gestionnaires.
     @return La liste des objets Entity des gestionnaires récupérés.
     */
    public List<GestionnaireDTO> getAllGestionnaires() {
        List<Gestionnaire> gestionnaires = gestionnaireRepository.findAll();
        return gestionnaires.stream().map(gestionnaire -> gestionnaireMapper.toDTO(gestionnaire)).collect(Collectors.toList());
    }

    /**
     Cette méthode permet de récupérer un gestionnaire en utilisant son identifiant et en utilisant le repository.
     @param id L'identifiant du gestionnaire à récupérer.
     @return L'objet Entity du gestionnaire récupéré.
     @throws EntityNotFoundException Si le gestionnaire n'a pas été trouvé avec l'identifiant donné.
     */
    public GestionnaireDTO getGestionnaireById(Long id) {
        System.out.println("debut service");
        Gestionnaire gestionnaire = gestionnaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gestionnaire not found"));
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    /**
     Cette méthode permet de créer un gestionnaire en utilisant un objet DTO et de le sauvegarder en utilisant le repository.
     @param gestionnaireDTO L'objet DTO contenant les informations du gestionnaire à créer.
     @return L'objet Entity du gestionnaire créé.
     */
    public GestionnaireDTO saveGestionnaire(GestionnaireDTO gestionnaireDTO) {
        System.out.println("debut service");
        Gestionnaire gestionnaire = gestionnaireMapper.toEntity(gestionnaireDTO);
        gestionnaire = gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    /**
     Cette méthode permet de mettre à jour un gestionnaire en utilisant son identifiant et en utilisant le repository.
     @param gestionnaireDTO L'objet DTO contenant les informations du gestionnaire à mettre à jour.
     @return L'objet Entity du gestionnaire mis à jour.
     */
    public GestionnaireDTO updateGestionnaire(GestionnaireDTO gestionnaireDTO) {
        Optional<Gestionnaire> oldGestionnaire = gestionnaireRepository.findById(gestionnaireDTO.getIdGestionnaire());
        if (oldGestionnaire.isEmpty()) throw new EntityNotFoundException("Gestionnaire not found");
        Gestionnaire gestionnaire = oldGestionnaire.get();
        gestionnaire.setNom(gestionnaireDTO.getNom());
        gestionnaire.setSalles(gestionnaireDTO.getSalles());
        gestionnaire.setPresident(gestionnaireDTO.getPresident());
        gestionnaire.setTypeGestionnaire(gestionnaireDTO.getTypeGestionnaire());
        gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    /**
     * Cette méthode permet de supprimer un gestionnaire en utilisant son identifiant et en utilisant le repository.
     * @param id L'identifiant du gestionnaire à supprimer.
     */
    public boolean deleteGestionnaire(Long id) {
        gestionnaireRepository.deleteById(id);
        return true;
    }
}