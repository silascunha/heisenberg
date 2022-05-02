package br.dev.silascunha.heisenberg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.silascunha.heisenberg.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Integer> {

}
