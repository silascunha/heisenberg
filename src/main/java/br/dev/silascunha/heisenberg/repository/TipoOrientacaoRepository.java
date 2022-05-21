package br.dev.silascunha.heisenberg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;

public interface TipoOrientacaoRepository extends JpaRepository<TipoOrientacao, Integer> {

    TipoOrientacao findByNomeIgnoreCase(String nome);

}
