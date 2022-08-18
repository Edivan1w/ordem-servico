package br.com.edivan.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.edivan.app.dto.TecnicoDto;
import br.com.edivan.app.model.Tecnico;
import br.com.edivan.app.service.TecnicoService;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {
	
	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDto> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(new TecnicoDto(tecnicoService.findById(id)));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDto>> findAll(){
		List<TecnicoDto> listDto = tecnicoService.findAll()
				.stream().map(tec -> new TecnicoDto(tec))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDto> create(@RequestBody TecnicoDto dto){
		Tecnico tecnico = tecnicoService.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tecnico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TecnicoDto(tecnico));
	
	}
}
