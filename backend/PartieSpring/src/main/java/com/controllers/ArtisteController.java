package com.controllers;

import com.dtos.ArtisteDTO;
import org.springframework.web.bind.annotation.*;

import com.services.impl.ArtisteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/artistes")
public class ArtisteController {
	
	private final ArtisteServiceImpl artisteService;

	public ArtisteController(ArtisteServiceImpl artisteService) {
		this.artisteService = artisteService;
	}

	@GetMapping
	public List<ArtisteDTO> getDogs() {
		return artisteService.getAllArtistes();
	}

	@GetMapping("/{id}")
	public ArtisteDTO getArtiste(@PathVariable Integer id){
		return artisteService.getArtisteById(id);
	}

	@PostMapping
	public ArtisteDTO saveArtiste(final @RequestBody ArtisteDTO artisteDTO){
		return artisteService.saveArtiste(artisteDTO);
	}

	@DeleteMapping("/{id}")
	public Boolean deleteArtiste(@PathVariable Integer id){
		return artisteService.deleteArtiste(id);
	}
	
}
