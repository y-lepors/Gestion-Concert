package api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import api.repositories.SoireeRepository;
import api.dtos.SoireeDTO;
import api.entities.Soiree;
import api.mappers.SoireeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SoireeService {
	@Autowired
	private SoireeRepository soireeRepository;

	@Autowired
	private SoireeMapper soireeMapper;

	public List<SoireeDTO> getAllSoirees() {
		List<Soiree> soirees = soireeRepository.findAll();
		return soirees.stream().map(soiree -> soireeMapper.toDTO(soiree)).collect(Collectors.toList());
	}

	public SoireeDTO saveSoiree(SoireeDTO soireeDTO) {
		Soiree soiree = soireeMapper.toEntity(soireeDTO);
		soiree = soireeRepository.save(soiree);
		return soireeMapper.toDTO(soiree);
	}

	public SoireeDTO getSoireeById(Long id) {
		Soiree soiree = soireeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
		return soireeMapper.toDTO(soiree);
	}

	public boolean deleteSoiree(Long id) {
		soireeRepository.deleteById(id);
		return true;
	}

	public void updateSoiree(SoireeDTO soireeDTO) {
		Optional<Soiree> oldSoiree = soireeRepository.findById(soireeDTO.getIdSoiree());
		if (oldSoiree.isEmpty()) throw new EntityNotFoundException("Soiree not found");
		Soiree soiree = oldSoiree.get();
		soiree.setSalle(soireeDTO.getSalle());
		soiree.setNom(soireeDTO.getNom());
		soiree.setConcerts(soireeDTO.getConcerts());
		soireeRepository.save(soiree);
	}
}