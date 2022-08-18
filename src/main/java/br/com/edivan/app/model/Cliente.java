package br.com.edivan.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa{

	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico>ordemServicos = new ArrayList<OrdemServico>();
	
	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}
	
	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}
	
}
