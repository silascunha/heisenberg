package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;

import br.dev.silascunha.heisenberg.service.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;
import br.dev.silascunha.heisenberg.repository.TipoOrientacaoRepository;
import br.dev.silascunha.heisenberg.service.TipoOrientacaoService;
import br.dev.silascunha.heisenberg.service.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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

	@Transactional
	@Override
	public TipoOrientacao salvarTipoOrientacao(TipoOrientacao tipoOrientacao) {
		validarTipoOrientacao(tipoOrientacao, null);
		tipoOrientacao.setId(null);
		tipoOrientacao = tipoOrientacaoRepository.save(tipoOrientacao);

		return tipoOrientacao;
	}

	@Override
	@Transactional
	public TipoOrientacao atualizarTipoOrientacao(TipoOrientacao tipoOrientacao, Integer tipoId) {
		validarTipoOrientacao(tipoOrientacao, tipoId);

		TipoOrientacao tipoOrientacaoDB = tipoOrientacaoRepository.findById(tipoId).orElseThrow(() -> new ResourceNotFoundException("TipoOrientacao não encontrado com o id {" + tipoId + "}"));
		tipoOrientacaoDB.setNome(tipoOrientacao.getNome());

		tipoOrientacaoRepository.save(tipoOrientacaoDB);
		return tipoOrientacaoDB;
	}

	private void validarTipoOrientacao(TipoOrientacao tipoOrientacao, Integer tipoId) {
		if (tipoOrientacao.getNome() == null || tipoOrientacao.getNome().isBlank()) {
			throw new ValidacaoException("O nome do tipo é obrigatório");
		}

		TipoOrientacao tipoOrientacaoDB = tipoOrientacaoRepository.findByNomeIgnoreCase(tipoOrientacao.getNome());

		boolean nomeTipoExiste = tipoOrientacaoDB != null && !tipoOrientacaoDB.getId().equals(tipoId);

		if (nomeTipoExiste) {
			throw new ValidacaoException("Já existe um tipo de orientação com o mesmo nome");
		}
	}
}
