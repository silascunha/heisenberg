package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;
import br.dev.silascunha.heisenberg.repository.TipoOrientacaoRepository;
import br.dev.silascunha.heisenberg.service.TipoOrientacaoService;
import br.dev.silascunha.heisenberg.service.exception.ResourceNotFoundException;

@Service
public class TipoOrientacaoServiceImpl implements TipoOrientacaoService {

	@Autowired
	private TipoOrientacaoRepository tipoOrientacaoRepository;

	@Override
	public TipoOrientacao getTipoOrientacaoById(Integer id) {
		TipoOrientacao tipoOrientacao = tipoOrientacaoRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("TipoOrientacao não encontrado com o id {" + id + "}"));


		return tipoOrientacao;
	}

	@Override
	public List<TipoOrientacao> listarTiposOrientacao() {
		List<TipoOrientacao> tiposOrientacao = tipoOrientacaoRepository.findAll();

		return tiposOrientacao;
	}
	
}
