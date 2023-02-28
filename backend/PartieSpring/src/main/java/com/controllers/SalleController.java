package com.controllers;

import com.dtos.SalleDTO;
import com.entities.Salle;
import com.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;

    @PostMapping
    public ResponseEntity<SalleDTO> createSalle(@RequestBody SalleDTO salleDTO) {
        Salle salle = salleService.createSalle(salleDTO);
        return new ResponseEntity<>(salleService.convertToDTO(salle), HttpStatus.CREATED);
    }

    @GetMapping("/{idSalle}")
    public ResponseEntity<SalleDTO> getSalle(@PathVariable Long idSalle) {
        Salle salle = salleService.getSalle(idSalle);
        return new ResponseEntity<>(salleService.convertToDTO(salle), HttpStatus.OK);
    }

    @PutMapping("/{idSalle}")
    public ResponseEntity<SalleDTO> updateSalle(@PathVariable Long idSalle, @RequestBody SalleDTO salleDTO) {
        Salle salle = salleService.updateSalle(idSalle, salleDTO);
        return new ResponseEntity<>(salleService.convertToDTO(salle), HttpStatus.OK);
    }

    @DeleteMapping("/{idSalle}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long idSalle) {
        salleService.deleteSalle(idSalle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
