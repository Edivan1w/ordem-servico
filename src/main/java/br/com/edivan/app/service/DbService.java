package br.com.edivan.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivan.app.model.Cliente;
import br.com.edivan.app.model.OrdemServico;
import br.com.edivan.app.model.Tecnico;
import br.com.edivan.app.model.enume.Prioridade;
import br.com.edivan.app.model.enume.Status;
import br.com.edivan.app.repositories.ClienteRepository;
import br.com.edivan.app.repositories.OrdemServicoRepository;
import br.com.edivan.app.repositories.TecnicoRepository;

@Service
public class DbService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	
	public void instanciaDB() {
		Cliente c1 = new Cliente(null, "Marcos Silva", "033.185.620-41", "(98) 9999-7777");
        Tecnico t1 = new Tecnico(null, "Simone Castro", "220.864.600-23", "()98 9999-8888");
        OrdemServico os = new OrdemServico(null, Prioridade.ALTA, "Teste de criação", Status.ANDAMENTO, t1, c1);
        
        c1.getOrdemServicos().add(os);
        t1.getOrdemServicos().add(os);
        
        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));
        ordemServicoRepository.saveAll(Arrays.asList(os));
	}

}
