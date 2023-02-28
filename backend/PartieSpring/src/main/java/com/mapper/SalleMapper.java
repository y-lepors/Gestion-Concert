package com.mapper;

import org.mapstruct.Mapper;

import com.dtos.SalleDto;
import com.entities.Salle;

@Mapper(componentModel = "spring")
public interface SalleMapper {
    SalleDto toDto(Salle salle);

    Salle toEntity(SalleDto salleDto);
}
