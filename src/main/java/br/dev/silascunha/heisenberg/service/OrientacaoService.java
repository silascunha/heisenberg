package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.dto.OrientacaoOutput;
import br.dev.silascunha.heisenberg.model.Orientacao;

public interface OrientacaoService {
    
    OrientacaoOutput getOrientacaoById(Integer id);

    List<OrientacaoOutput> getAllOrientacoes();
    
    Orientacao saveOrientacao(OrientacaoInput orientacaoInput);
    
    Orientacao updateOrientacao(OrientacaoInput orientacaoInput, Integer id);
    
    void deleteOrientacao(Integer id);
    
}
