package br.com.edivan.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivan.app.dto.TecnicoDto;
import br.com.edivan.app.model.Tecnico;
import br.com.edivan.app.repositories.TecnicoRepository;
import br.com.edivan.app.service.exceptions.ObjectNotFoundException;
import br.com.edivan.app.service.util.TecnicoUtil;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	public Tecnico findById(Long id) {
		return tecnicoRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("objeto não encontrado id: " + id + Tecnico.class.getName()));
	}
	
	public List<Tecnico> findAll(){
		return tecnicoRepository.findAll();
	}
	
	public Tecnico create(TecnicoDto dto) {
		return tecnicoRepository.save(TecnicoUtil.toTecnico(dto));
		
	}
	
}
