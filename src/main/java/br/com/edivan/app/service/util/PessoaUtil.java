package br.com.edivan.app.service.util;

import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.model.PessoaDto;

public class PessoaUtil {

	public static Pessoa toPessoa(PessoaDto dto, Pessoa pessoa) {
		  pessoa.setNome(dto.getNome());
		  pessoa.setCpf(dto.getCpf());
		  pessoa.setTelefone(dto.getTelefone());
		  return pessoa;
	}

         

	
}