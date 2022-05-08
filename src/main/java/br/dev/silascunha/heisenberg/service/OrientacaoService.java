package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;

public interface OrientacaoService {
    
    OrientacaoInput getOrientacaoById(Integer id);

    List<OrientacaoInput> getAllOrientacoes();
    
    Orientacao saveOrientacao(OrientacaoInput orientacaoInput);
    
    Orientacao updateOrientacao(OrientacaoInput orientacaoInput, Integer id);
    
    void deleteOrientacao(Integer id);
    
}
