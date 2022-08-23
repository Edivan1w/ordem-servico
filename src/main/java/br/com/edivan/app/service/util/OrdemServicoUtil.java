package br.com.edivan.app.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.edivan.app.dto.OrdemServicoDto;
import br.com.edivan.app.model.OrdemServico;
import br.com.edivan.app.model.enume.Prioridade;
import br.com.edivan.app.model.enume.Status;
import br.com.edivan.app.service.ClienteService;
import br.com.edivan.app.service.TecnicoService;

@Component
public class OrdemServicoUtil {

	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public OrdemServico toOrdemServico(OrdemServicoDto dto) {
		return new OrdemServico(null, Prioridade.toEnum(dto.getPrioridade()), dto.getObservacoes(), Status.toEnum( dto.getStatus()),
				tecnicoService.findById(dto.getTecnico()), clienteService.findById(dto.getCliente()));
	}

}
