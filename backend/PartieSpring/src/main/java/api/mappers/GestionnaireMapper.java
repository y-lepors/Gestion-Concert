package api.mappers;

import api.dtos.GestionnaireDTO;
import api.dtos.SoireeDTO;
import api.entities.Gestionnaire;
import api.entities.Soiree;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


/**

 Cette classe représente le mapper GestionnaireMapper qui permet de mapper l'entité Gestionnaire et le DTO GestionnaireDTO.
 */
@Component
public class GestionnaireMapper {

    public GestionnaireDTO toDTO(Gestionnaire gestionnaire){
        System.out.println("debut mapper");
        GestionnaireDTO gestionnaireDTO = new GestionnaireDTO();
        gestionnaireDTO.setIdGestionnaire(gestionnaire.getIdGestionnaire());
        gestionnaireDTO.setNom(gestionnaire.getNom());
        gestionnaireDTO.setPresident(gestionnaire.getPresident());
        gestionnaireDTO.setSalles(gestionnaire.getSalles());
        gestionnaireDTO.setTypeGestionnaire(gestionnaire.getTypeGestionnaire());
        return gestionnaireDTO;
    }

    public Gestionnaire toEntity(GestionnaireDTO gestionnaireDTO){
        System.out.println("debut mapper");
        Gestionnaire gestionnaire = new Gestionnaire();
        gestionnaire.setIdGestionnaire(gestionnaireDTO.getIdGestionnaire());
        gestionnaire.setNom(gestionnaireDTO.getNom());
        gestionnaire.setPresident(gestionnaireDTO.getPresident());
        gestionnaire.setSalles(gestionnaireDTO.getSalles());
        gestionnaire.setTypeGestionnaire(gestionnaireDTO.getTypeGestionnaire());
        return gestionnaire;
    }
}