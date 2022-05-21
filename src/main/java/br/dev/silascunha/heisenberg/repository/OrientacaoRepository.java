package br.dev.silascunha.heisenberg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.silascunha.heisenberg.model.Orientacao;

import java.util.List;

public interface OrientacaoRepository extends JpaRepository<Orientacao, Integer>{

    List<Orientacao> findAllByExameId(Integer exameId);

}
