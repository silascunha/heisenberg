package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.OrientacaoDTO;
import br.dev.silascunha.heisenberg.model.Orientacao;

public interface OrientacaoService {
    
    OrientacaoDTO getOrientacaoById(Integer id);

    List<OrientacaoDTO> getAllOrientacoes();
    
    Orientacao saveOrientacao(OrientacaoDTO orientacaoDto);
    
    Orientacao updateOrientacao(OrientacaoDTO orientacaoDto, Integer id);
    
    void deleteOrientacao(Integer id);
    
}
