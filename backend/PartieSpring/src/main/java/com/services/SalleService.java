package com.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtos.SalleDto;
import com.entities.Salle;
import com.mapper.SalleMapper;
import com.repositories.SalleRepository;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    private SalleMapper salleMapper;

    public List<SalleDto> getAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return salles.stream().map(salleMapper::toDto).collect(Collectors.toList());
    }

    public SalleDto getSalleById(Long idSalle) {
        Salle salle = salleRepository.findById(idSalle)
                .orElseThrow(() -> new EntityNotFoundException("Salle non trouvée avec l'ID: " + idSalle));
        return salleMapper.toDto(salle);
    }

    public SalleDto createSalle(SalleDto salleDto) {
        Salle salle = salleMapper.toEntity(salleDto);
        Salle newSalle = salleRepository.save(salle);
        return salleMapper.toDto(newSalle);
    }

    public SalleDto updateSalle(Long idSalle, SalleDto salleDto) {
        Salle salle = salleRepository.findById(idSalle)
                .orElseThrow(() -> new EntityNotFoundException("Salle non trouvée avec l'ID: " + idSalle));
        salle.setNom(salleDto.getNom());
        salle.setNombrePlaces(salleDto.getNombrePlaces());
        salle.setAdresse(salleDto.getAdresse());
        Salle updatedSalle = salleRepository.save(salle);
        return salleMapper.toDto(updatedSalle);
    }

    public void deleteSalle(Long idSalle) {
        salleRepository.deleteById(idSalle);
    }
}
