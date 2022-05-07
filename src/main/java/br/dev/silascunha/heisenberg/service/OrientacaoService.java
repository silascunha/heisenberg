package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.model.Orientacao;

public interface OrientacaoService {
    
    Orientacao getOrientacaoById(Integer id);

    List<Orientacao> getAllOrientacoes();
    
    Orientacao saveOrientacao(Orientacao orientacao);
    
    Orientacao updateOrientacao(Orientacao orientacao, Integer id);
    
    void deleteOrientacao(Integer id);
    
}
