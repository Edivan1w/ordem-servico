package br.com.edivan.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.edivan.app.dto.OrdemServicoDto;
import br.com.edivan.app.model.OrdemServico;
import br.com.edivan.app.service.OrdemServicoService;

@RestController
@RequestMapping("/ordem-de-servico")
public class OrdemServicoContoller {
	
	@Autowired
	private OrdemServicoService ordemServicoService;

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDto> findById(@PathVariable Long id){
		return ResponseEntity.ok()
				.body(new OrdemServicoDto(ordemServicoService.findById(id)));
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoDto>> findAll(){
		List<OrdemServicoDto> list = ordemServicoService.findAll()
				.stream().map(o -> new OrdemServicoDto(o))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OrdemServicoDto> create(@RequestBody @Valid OrdemServicoDto dto){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordemServicoService.create(dto).getId()).toUri();
		return ResponseEntity.created(uri).body(new OrdemServicoDto(ordemServicoService.create(dto)));
	}

}









