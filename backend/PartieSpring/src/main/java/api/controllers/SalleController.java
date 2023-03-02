package api.controllers;

import api.dtos.SalleDTO;
import api.services.SalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public ResponseEntity<List<SalleDTO>> getSalles() {
        List<SalleDTO> salles = salleService.getAllSalles();
        if (salles.isEmpty()) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:8080")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .body(salles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleDTO> getSalle(@PathVariable Long id){
        SalleDTO salle = salleService.getSalleById(id);
        if (salle == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:8080")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .body(salle);
    }

    @PostMapping
    public ResponseEntity<SalleDTO> saveSalle(final @RequestBody SalleDTO salleDTO){
        SalleDTO salle = salleService.saveSalle(salleDTO);
        if (salle == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:8080")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .body(salle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSalle(@PathVariable Long id) {
        Boolean isDeleted = salleService.deleteSalle(id);
        if (!isDeleted) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:8080")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .body(isDeleted);
    }

    @PostMapping("/update")
    public ResponseEntity<SalleDTO> updateSalle(final @RequestBody SalleDTO salleDTO) {
        SalleDTO salle = salleService.updateSalle(salleDTO);
        if (salle == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:8080")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .body(salle);
    }
}