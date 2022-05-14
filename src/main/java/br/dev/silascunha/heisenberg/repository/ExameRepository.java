package br.dev.silascunha.heisenberg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.dev.silascunha.heisenberg.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Integer> {

    static final String QUERY_EXAMES_PESQUISA = 
            "SELECT DISTINCT ex.* FROM EXAME ex INNER JOIN SINONIMO sin ON ex.id_exame = sin.id_exame " +
            "WHERE LOWER(ex.nome_exame) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(sin.nome_sinonimo) LIKE LOWER(CONCAT('%', ?1, '%'))";

    @Query(value = QUERY_EXAMES_PESQUISA, nativeQuery = true)
    List<Exame> searchExame(String searchTerm);

}
