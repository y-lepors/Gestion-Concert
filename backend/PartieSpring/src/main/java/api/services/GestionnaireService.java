package api.services;

import api.dtos.GestionnaireDTO;
import api.entities.Gestionnaire;
import api.mappers.GestionnaireMapper;
import api.mappers.SoireeMapper;
import api.repositories.GestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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

    public GestionnaireDTO getGestionnaire(Long idGestionnaire) {
        Gestionnaire gestionnaire = gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire not found"));
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    public GestionnaireDTO createGestionnaire(GestionnaireDTO gestionnaireDTO) {
        Gestionnaire gestionnaire = gestionnaireMapper.toEntity(gestionnaireDTO);
        gestionnaire = gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    public GestionnaireDTO updateGestionnaire(Long idGestionnaire, GestionnaireDTO gestionnaireDTO) {
        Gestionnaire gestionnaire = gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire not found"));
        gestionnaire.setNom(gestionnaireDTO.getNom());
        gestionnaire.setPresident(gestionnaireDTO.getPresident());
        gestionnaire = gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.toDTO(gestionnaire);
    }

    public void deleteGestionnaire(Long idGestionnaire) {
        gestionnaireRepository.deleteById(idGestionnaire);
    }

}