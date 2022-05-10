package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;
import br.dev.silascunha.heisenberg.service.TipoOrientacaoService;

@RestController
@RequestMapping("/tiposOrientacao")
public class TipoOrientacaoController {
	
	@Autowired
	private TipoOrientacaoService tipoOrientacaoService;


	@GetMapping
	public ResponseEntity<List<TipoOrientacao>> listarTiposOrientacao() {
		List<TipoOrientacao> tiposOrientacao = tipoOrientacaoService.listarTiposOrientacao();

		return ResponseEntity.ok().body(tiposOrientacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoOrientacao> getTipoOrientacaoById(Integer id) {
		TipoOrientacao tipoOrientacao = tipoOrientacaoService.getTipoOrientacaoById(id);

		return ResponseEntity.ok().body(tipoOrientacao);
	}
}
