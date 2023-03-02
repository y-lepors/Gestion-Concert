package api.services;

import api.dtos.ConcertDTO;
import api.dtos.SalleDTO;
import api.entities.Concert;
import api.entities.Salle;
import api.entities.Soiree;
import api.mappers.ConcertMapper;
import api.repositories.ConcertRepository;
import api.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 Cette classe sert de service pour l'objet Concert. Elle permet de faire le lien entre le contrôleur et le repository
 tout en réalisant des opérations de conversion entre les objets DTO et Entity.
 */
@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ConcertMapper concertMapper;

    /**
     Cette méthode permet de récupérer tous les concert.
     @return La liste des objets Entity des concerts récupérés.
     */
    public List<ConcertDTO> getAllConcerts() {
        List<Concert> concerts = concertRepository.findAll();
        return concerts.stream().map(concert -> concertMapper.toDTO(concert)).collect(Collectors.toList());
    }

    /**
     Cette méthode permet de créer un concert en utilisant un objet DTO et de le sauvegarder en utilisant le repository.
     @param concertDTO L'objet DTO contenant les informations du concert à créer.
     @return L'objet Entity du concert créé.
     */
    public ConcertDTO saveConcert(ConcertDTO concertDTO) {
        Concert concert = concertMapper.toEntity(concertDTO);
        concert = concertRepository.save(concert);
        return concertMapper.toDTO(concert);
    }

    /**
     Cette méthode permet de récupérer un concert en utilisant son identifiant et en utilisant le repository.
     @param id L'identifiant du concert à récupérer.
     @return L'objet Entity du concert récupéré.
     @throws EntityNotFoundException Si le concert n'a pas été trouvé avec l'identifiant donné.
     */
    public ConcertDTO getConcertById(Long id) {
        Concert concert = concertRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertMapper.toDTO(concert);
    }

    /**
     Cette méthode permet de mettre à jour un concert en utilisant son identifiant et en utilisant le repository.
     @param concertDTO L'objet DTO contenant les informations du concert à mettre à jour.
     @return L'objet Entity du concert mis à jour.
     */
    public void updateConcert(ConcertDTO concertDTO) {
        Optional<Concert> oldConcert = concertRepository.findById(concertDTO.getIdConcert());
        if (oldConcert.isEmpty()) throw new EntityNotFoundException("Concert not found");
        Concert concert = oldConcert.get();
        concert.setDateConcert(concertDTO.getDateConcert());
        concert.setDuree(concertDTO.getDuree());
        concert.setSalle(concertDTO.getSalle());
        concert.setSoiree(concertDTO.getSoiree());
        concertRepository.save(concert);
    }

    /**
     * Cette méthode permet de supprimer un concert en utilisant son identifiant et en utilisant le repository.
     * @param id L'identifiant du concert à supprimer.
     */
    public boolean deleteConcert(Long id) {
        concertRepository.deleteById(id);
        return true;
    }
}
