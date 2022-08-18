package br.com.edivan.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edivan.app.model.Cliente;
import br.com.edivan.app.model.OrdemServico;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
