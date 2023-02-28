package com.services;

import com.dtos.GestionnaireDTO;
import com.entities.Gestionnaire;
import com.repositories.GestionnaireRepository;
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
    private final GestionnaireRepository gestionnaireRepository;

    public GestionnaireDTO getGestionnaire(Long idGestionnaire) {
        Gestionnaire gestionnaire = gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire", "idGestionnaire", idGestionnaire));
        return gestionnaireMapper.gestionnaireToGestionnaireDTO(gestionnaire);
    }

    public GestionnaireDTO createGestionnaire(GestionnaireDTO gestionnaireDTO) {
        Gestionnaire gestionnaire = gestionnaireMapper.gestionnaireDTOToGestionnaire(gestionnaireDTO);
        gestionnaire = gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.gestionnaireToGestionnaireDTO(gestionnaire);
    }

    public GestionnaireDTO updateGestionnaire(Long idGestionnaire, GestionnaireDTO gestionnaireDTO) {
        Gestionnaire gestionnaire = gestionnaireRepository.findById(idGestionnaire).orElseThrow(() -> new EntityNotFoundException("Gestionnaire", "idGestionnaire", idGestionnaire));
        gestionnaire.setNom(gestionnaireDTO.getNom());
        gestionnaire.setPresident(gestionnaireDTO.getPresident());
        gestionnaire.setTypeGestionnaire(gestionnaireDTO.getTypeGestionnaire());
        gestionnaire = gestionnaireRepository.save(gestionnaire);
        return gestionnaireMapper.gestionnaireToGestionnaireDTO(gestionnaire);
    }

    public void deleteGestionnaire(Long idGestionnaire) {
        gestionnaireRepository.deleteById(idGestionnaire);
    }

}