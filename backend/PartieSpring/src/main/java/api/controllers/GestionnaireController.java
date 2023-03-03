package api.controllers;

import api.dtos.GestionnaireDTO;
import api.services.GestionnaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gestionnaires")
public class GestionnaireController {

    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    @GetMapping
    public ResponseEntity<List<GestionnaireDTO>> getGestionnaires() {
        List<GestionnaireDTO> gestionnaires = gestionnaireService.getAllGestionnaires();
        if (gestionnaires.isEmpty()) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(gestionnaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestionnaireDTO> getGestionnaire(@PathVariable Long id){
        GestionnaireDTO gestionnaire = gestionnaireService.getGestionnaireById(id);
        if (gestionnaire == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(gestionnaire);
    }

    @PostMapping
    public ResponseEntity<GestionnaireDTO> saveGestionnaire(final @RequestBody GestionnaireDTO gestionnaireDTO){
        GestionnaireDTO gestionnaire = gestionnaireService.saveGestionnaire(gestionnaireDTO);
        if (gestionnaire == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(gestionnaire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGestionnaire(@PathVariable Long id){
        Boolean deleted = gestionnaireService.deleteGestionnaire(id);
        if (!deleted) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(deleted);
    }

    @PostMapping("/update")
    public ResponseEntity<GestionnaireDTO> updateGestionnaire(final @RequestBody GestionnaireDTO gestionnaireDTO){
        GestionnaireDTO gestionnaire = gestionnaireService.updateGestionnaire(gestionnaireDTO);
        if (gestionnaire == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(gestionnaire);
    }
}