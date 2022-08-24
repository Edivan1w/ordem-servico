package br.com.edivan.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivan.app.dto.OrdemServicoDto;
import br.com.edivan.app.model.OrdemServico;
import br.com.edivan.app.repositories.OrdemServicoRepository;
import br.com.edivan.app.service.exceptions.ObjectNotFoundException;
import br.com.edivan.app.service.util.OrdemServicoUtil;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	@Autowired
	private OrdemServicoUtil ordemServicoUtil;

	public OrdemServico findById(Long id) {
		return ordemServicoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<OrdemServico> findAll() {
		return ordemServicoRepository.findAll();
	}

	@Transactional
	public OrdemServico create(OrdemServicoDto dto) {
		return ordemServicoRepository.save(ordemServicoUtil.toOrdemServico(dto));
	}

	@Transactional
	public OrdemServico update(OrdemServicoDto dto) {
		OrdemServico servico = this.findById(dto.getId());
		return ordemServicoUtil.atualizar(servico, dto);
	}

}
