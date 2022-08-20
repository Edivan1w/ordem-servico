package br.com.edivan.app.service.util;

import br.com.edivan.app.dto.TecnicoDto;
import br.com.edivan.app.model.Pessoa;
import br.com.edivan.app.model.Tecnico;

public class TecnicoUtil {

	public static Pessoa toTecnico(TecnicoDto dto) {
		return new Tecnico(null, dto.getNome(), dto.getCpf(), dto.getTelefone());
		
	}

}
