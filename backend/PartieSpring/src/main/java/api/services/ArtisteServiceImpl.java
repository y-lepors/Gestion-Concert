package api.services;

import api.dtos.ArtisteDTO;
import api.entities.Artiste;
import api.repositories.ArtisteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("artisteService")
public class ArtisteServiceImpl implements ArtisteService {

	private final ArtisteRepository artisteRepo;

    public ArtisteServiceImpl(ArtisteRepository artisteRepo){
        this.artisteRepo = artisteRepo;
    }

    @Override
    public ArtisteDTO saveDog(ArtisteDTO artisteDTO) {
        Artiste artiste = artisteDTOToEntity(artisteDTO);
        artiste = artisteRepo.save(artiste);
        return artisteEntityToDTO(artiste);
    }

    @Override
    public ArtisteDTO getArtisteById(Integer id) {
        Artiste artiste = artisteRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Artiste not found"));
        return artisteEntityToDTO(artiste);
    }

    @Override
    public boolean deleteArtiste(Integer id) {
        artisteRepo.deleteById(id);
        return true;
    }

    @Override
    public List<ArtisteDTO> getAllArtistes() {
        List<ArtisteDTO> artisteDTOs = new ArrayList<>();
        List<Artiste> artistes = artisteRepo.findAll();
        artistes.forEach(artiste -> {
            artisteDTOs.add(artisteEntityToDTO(artiste));
        });
        return artisteDTOs;
    }

    private ArtisteDTO artisteEntityToDTO(Artiste artiste){
        ArtisteDTO artisteDTO = new ArtisteDTO();
        artisteDTO.setId(artiste.getId());
        artisteDTO.setName(artiste.getNom());
        artisteDTO.setPrenom(artisteDTO.getPrenom());
        return artisteDTO;
    }

    private Artiste artisteDTOToEntity(ArtisteDTO artisteDTO){
        Artiste artiste = new Artiste();
        artiste.setNom(artisteDTO.getNom());
        artiste.setId(artisteDTO.getId());
        artiste.setPrenom(artisteDTO.getPrenom());
        return artiste;
    }
}
