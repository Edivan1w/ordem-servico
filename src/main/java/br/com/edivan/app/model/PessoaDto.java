package br.com.edivan.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaDto implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long id;
		@NotEmpty(message = "O campo nome é obrigatório")
		private String nome;
		@CPF
		@NotEmpty(message = "O campo CPF é obrigatório")
		private String cpf;
		@NotEmpty(message = "O campo telefone é obrigatório")
		private String telefone;
		
		public PessoaDto() {}
		public PessoaDto(Pessoa pessoa) {
			super();
			this.id = pessoa.getId();
			this.nome = pessoa.getNome();
			this.cpf = pessoa.getCpf();
			this.telefone = pessoa.getTelefone();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
