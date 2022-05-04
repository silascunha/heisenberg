package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.model.Exame;

public interface ExameService {
    
    Exame getExameById(Integer id);

    List<Exame> pesquisarExame(String pesquisa);

    List<Exame> getAllExames();
    
    Exame saveExame(Exame exame);
    
    Exame updateExame(Exame exame, Integer id);
    
    void deleteExame(Integer id);
    
}
