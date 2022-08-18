package br.com.edivan.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edivan.app.model.OrdemServico;
import br.com.edivan.app.model.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}