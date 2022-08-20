package br.com.edivan.app.dto;

import java.io.Serializable;

import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.model.PessoaDto;

public class ClienteDto extends PessoaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteDto() {
		super();
	}

	public ClienteDto(Pessoa pessoa) {
		super(pessoa);
	}

	
	
	
	
	

}
