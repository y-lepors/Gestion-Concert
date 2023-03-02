package api.controllers;

import api.dtos.ConcertDTO;
import api.services.ConcertService;
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
    public List<ConcertDTO> getConcerts() {
        return concertService.getAllConcerts();
    }

    @GetMapping("/{id}")
    public ConcertDTO getConcert(@PathVariable Long id) {
        return concertService.getConcertById(id);
    }

    @PostMapping
    public ConcertDTO saveConcert(final @RequestBody ConcertDTO concertDTO) {
        return concertService.saveConcert(concertDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteConcert(@PathVariable Long id) {
        return concertService.deleteConcert(id);
    }
}