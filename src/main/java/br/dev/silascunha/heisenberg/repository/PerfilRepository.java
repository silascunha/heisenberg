package br.dev.silascunha.heisenberg.repository;

import br.dev.silascunha.heisenberg.model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilUsuario, Integer> {
}
