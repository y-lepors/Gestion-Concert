package com.mapper;

import com.dtos.GestionnaireDTO;
import com.entities.Gestionnaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**

 Cette classe représente le mapper GestionnaireMapper qui permet de mapper l'entité Gestionnaire et le DTO GestionnaireDTO.
 */
@Mapper(componentModel = "spring")
public interface GestionnaireMapper {
    GestionnaireDTO gestionnaireToGestionnaireDTO(Gestionnaire gestionnaire);

    Gestionnaire gestionnaireDTOToGestionnaire(GestionnaireDTO gestionnaireDTO);
}