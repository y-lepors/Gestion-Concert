package com.mapper;

import com.dtos.SalleDTO;
import com.entities.Salle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalleMapper {
    SalleMapper INSTANCE = Mappers.getMapper(SalleMapper.class);

    @Mapping(source = "gestionnaire.idGestionnaire", target = "gestionnaire")
    SalleDTO salleToSalleDTO(Salle salle);

    @Mapping(source = "gestionnaire", target = "gestionnaire.idGestionnaire")
    Salle salleDTOToSalle(SalleDTO salleDTO);
}
