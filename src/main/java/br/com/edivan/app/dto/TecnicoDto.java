package br.com.edivan.app.dto;

import java.io.Serializable;

import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.model.PessoaDto;

public class TecnicoDto extends PessoaDto implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public TecnicoDto(Pessoa pessoa) {
		super(pessoa);
	}



	public TecnicoDto() {
		super();
	}

	

}
