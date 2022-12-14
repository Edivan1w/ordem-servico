package br.com.edivan.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivan.app.dto.TecnicoDto;
import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.model.Tecnico;
import br.com.edivan.app.repositories.PessoaRepository;
import br.com.edivan.app.repositories.TecnicoRepository;
import br.com.edivan.app.service.exceptions.DataIntegratyViolationException;
import br.com.edivan.app.service.exceptions.ObjectNotFoundException;
import br.com.edivan.app.service.util.PessoaUtil;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Long id) {
		return tecnicoRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("objeto não encontrado id: " + id + Tecnico.class.getName()));
	}
	
	public List<Tecnico> findAll(){
		return tecnicoRepository.findAll();
	}
	
	public Tecnico create(TecnicoDto dto) {
		if(this.findByCpf(dto.getCpf()) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado no banco de dados");
		}
		return tecnicoRepository.save((Tecnico) PessoaUtil.toPessoa(dto, new Tecnico()));
	}
	@Transactional
	public void delete(Long id) {
		if(this.findById(id).getOrdemServicos().size() > 0) {
			throw new DataIntegratyViolationException("O tecnico possui ordens de serviço, não pode ser deletado");
		}
		tecnicoRepository.deleteById(id);
	}
	
	private Pessoa findByCpf(String cpf) {
		Pessoa pessoa = pessoaRepository.findByCpf(cpf);
		if(pessoa != null) {
			return pessoa;
		}
		return null;
	}
}
