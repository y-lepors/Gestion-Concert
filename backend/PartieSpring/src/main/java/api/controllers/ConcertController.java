package api.controllers;

import api.dtos.ConcertDTO;
import api.services.ConcertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {

    private final ConcertService concertService;

    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping
    public ResponseEntity<List<ConcertDTO>> getConcerts() {
        List<ConcertDTO> concerts = concertService.getAllConcerts();
        if (concerts.isEmpty()) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(concerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcertDTO> getConcert(@PathVariable Long id) {
        ConcertDTO concert = concertService.getConcertById(id);
        if (concert == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(concert);
    }

    @PostMapping
    public ResponseEntity<ConcertDTO> saveConcert(final @RequestBody ConcertDTO concertDTO) {
        ConcertDTO concert = concertService.saveConcert(concertDTO);
        if (concert == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(concert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteConcert(@PathVariable Long id) {
        Boolean deleted = concertService.deleteConcert(id);
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
    public ResponseEntity<ConcertDTO> updateConcert(final @RequestBody ConcertDTO concertDTO){
        ConcertDTO concert = concertService.updateConcert(concertDTO);
        if (concert == null) {
            return ResponseEntity.noContent()
                    .header("Access-Control-Allow-Origin", "http://localhost:5173")
                    .build();
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .body(concert);
    }
}