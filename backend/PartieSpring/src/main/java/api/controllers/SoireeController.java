package api.controllers;

import api.dtos.SoireeDTO;
import api.services.SoireeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {
	
	private final SoireeService soireeService;

	public SoireeController(SoireeService soireeService) {
		this.soireeService = soireeService;
	}

	@GetMapping
	public List<SoireeDTO> getSoirees() {
		return soireeService.getAllSoirees();
	}

	@GetMapping("/{id}")
	public SoireeDTO getSoiree(@PathVariable Long id){
		return soireeService.getSoireeById(id);
	}

	@PostMapping
	public SoireeDTO saveSoiree(final @RequestBody SoireeDTO soireeDTO){
		return soireeService.saveSoiree(soireeDTO);
	}

	@DeleteMapping("/{id}")
	public Boolean deleteSoiree(@PathVariable Long id){
		return soireeService.deleteSoiree(id);
	}

	@PostMapping("/update")
	public void updateSoiree(final @RequestBody SoireeDTO soireeDTO){
		soireeService.updateSoiree(soireeDTO);
	}
}