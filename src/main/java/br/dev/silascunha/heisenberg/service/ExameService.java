package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.ExameInput;
import br.dev.silascunha.heisenberg.model.Exame;

public interface ExameService {
    
    Exame getExameById(Integer id);

    List<Exame> pesquisarExame(String pesquisa);

    List<Exame> getAllExames();
    
    Exame saveExame(ExameInput exameInput);
    
    Exame updateExame(ExameInput exameInput, Integer id);
    
    void deleteExame(Integer id);
    
}
