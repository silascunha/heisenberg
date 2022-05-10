package br.dev.silascunha.heisenberg.service;

import java.util.List;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;

public interface TipoOrientacaoService {
	
	TipoOrientacao getTipoOrientacaoById(Integer id);

	List<TipoOrientacao> listarTiposOrientacao();
}
