package api.mappers;

import api.dtos.GestionnaireDTO;
import api.entities.Gestionnaire;
import org.mapstruct.Mapper;


/**

 Cette classe représente le mapper GestionnaireMapper qui permet de mapper l'entité Gestionnaire et le DTO GestionnaireDTO.
 */
@Mapper(componentModel = "spring")
public interface GestionnaireMapper {
    GestionnaireDTO gestionnaireToGestionnaireDTO(Gestionnaire gestionnaire);

    Gestionnaire gestionnaireDTOToGestionnaire(GestionnaireDTO gestionnaireDTO);
}