package br.com.edivan.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivan.app.dto.ClienteDto;
import br.com.edivan.app.model.Cliente;
import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.repositories.ClienteRepository;
import br.com.edivan.app.repositories.PessoaRepository;
import br.com.edivan.app.service.exceptions.DataIntegratyViolationException;
import br.com.edivan.app.service.exceptions.ObjectNotFoundException;
import br.com.edivan.app.service.util.PessoaUtil;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("objeto não encontrado id: " + id + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente create(ClienteDto dto) {
		if(this.findByCpf(dto.getCpf()) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado no banco de dados");
		}
		return clienteRepository.save((Cliente) PessoaUtil.toPessoa(dto, new Cliente()));
	}
	@Transactional
	public void delete(Long id) {
		if(this.findById(id).getOrdemServicos().size() > 0) {
			throw new DataIntegratyViolationException("O cliente possui ordens de serviço, não pode ser deletado");
		}
		clienteRepository.deleteById(id);
	}
	
	private Pessoa findByCpf(String cpf) {
		Pessoa pessoa = pessoaRepository.findByCpf(cpf);
		if(pessoa != null) {
			return pessoa;
		}
		return null;
	}
}
