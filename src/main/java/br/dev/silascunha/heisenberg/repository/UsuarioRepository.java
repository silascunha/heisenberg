package br.dev.silascunha.heisenberg.repository;

import br.dev.silascunha.heisenberg.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}
