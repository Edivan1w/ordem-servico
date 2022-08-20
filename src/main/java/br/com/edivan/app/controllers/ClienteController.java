package br.com.edivan.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.edivan.app.dto.ClienteDto;
import br.com.edivan.app.model.Cliente;
import br.com.edivan.app.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(new ClienteDto(clienteService.findById(id)));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(){
		List<ClienteDto> listDto = clienteService.findAll()
				.stream().map(tec -> new ClienteDto(tec))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> create(@RequestBody @Valid ClienteDto dto){
		Cliente tecnico = clienteService.create(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tecnico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(tecnico));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
